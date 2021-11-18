package com.example.moviedb.catalog.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.R
import com.example.moviedb.catalog.presentation.MovieState
import com.example.moviedb.catalog.presentation.MovieUserIntent
import com.example.moviedb.catalog.presentation.MovieViewModel
import com.example.moviedb.catalog.presentation.model.UiMovieItem
import com.example.moviedb.catalog.presentation.model.UiPopular
import com.example.moviedb.catalog.presentation.model.UiPopularItem
import com.example.moviedb.catalog.ui.adapter.MovieAdapter
import com.example.moviedb.catalog.ui.view.ErrorView
import com.example.moviedb.catalog.ui.view.LoadingView
import com.example.moviedb.commons.factory.ViewModelFactory
import com.example.moviedb.commons.mvi.MviUi
import com.example.moviedb.databinding.FragmentMovieCatalogBinding
import dagger.android.support.DaggerFragment
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class MovieCatalogFragment : DaggerFragment(), MviUi<MovieUserIntent, MovieState> {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var movieAdapter: MovieAdapter

    @Inject
    lateinit var movieItemDialogFragment: MovieItemDialogFragment

    private lateinit var binding: FragmentMovieCatalogBinding

    private lateinit var loading: LoadingView

    private lateinit var error: ErrorView

    private val liveDataOnChangeState: MutableLiveData<UiPopularItem?> = MutableLiveData()

    private val initialIntent = PublishSubject.create<MovieUserIntent.InitialUserIntent>()

    private val loadingIntent = PublishSubject.create<MovieUserIntent.MovieLoadingUserIntent>()

    val viewModel by viewModels<MovieViewModel> { viewModelFactory }

    var currentPageNum: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movie_catalog, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        loading = binding.loading
        error = binding.error
        setUpFragment()
    }

    private fun setUpFragment() {
        setupAdapter()
        subscribeUiStatesAndProcessUserIntents()
        onLiveDataSubscribe()
        executeInit(INI_PAGE)
        setLastItemListener()
    }

    private fun setupAdapter() {
        binding.rvMovies.adapter = movieAdapter
    }

    private fun liveData(): LiveData<UiPopularItem?> = liveDataOnChangeState

    private fun onLiveDataSubscribe() {
        liveData().observe(this, {
            if (it != null) {
                onItemClicked(it)
            }
        })
    }

    private fun executeInitialIntent(): Observable<MovieUserIntent.InitialUserIntent> =
        initialIntent

    private fun executeLoadingIntent(): Observable<MovieUserIntent.MovieLoadingUserIntent> =
        loadingIntent

    override fun userIntents(): Observable<MovieUserIntent> =
        Observable.merge(
            executeInitialIntent(),
            executeLoadingIntent()
        )

    private fun executeInit(pageNum: String) {
        initialIntent.onNext(MovieUserIntent.InitialUserIntent(pageNum))
    }

    private fun executeLoad(movieId: String) {
        loadingIntent.onNext(MovieUserIntent.MovieLoadingUserIntent(movieId))
    }

    fun setIncomingData(uiPopular: List<UiPopularItem>?) {
        when (uiPopular) {
            null -> setScreenForError(true)
            else -> movieAdapter.setData(uiPopular, liveDataOnChangeState)
        }
    }

    private fun subscribeUiStatesAndProcessUserIntents() {
        observeUiStates()
        viewModel.processUserIntents(userIntents())
    }

    private fun observeUiStates() {
        viewModel.liveData().observe(this, { uiState ->
            uiState?.let { renderUiStates(it) }
        })
    }

    override fun renderUiStates(uiState: MovieState) {
        when (uiState) {
            MovieState.DefaultState -> setDefaultState()
            MovieState.LoadingState -> setScreenForLoading(uiState.isLoading)
            is MovieState.SuccessPopularState -> {
                setScreenForSuccess(uiState.popular)
                currentPageNum = uiState.popular.page
            }
            is MovieState.ErrorState -> {
                setScreenForContent(false)
                setScreenForError(true)
            }
            is MovieState.SuccessItemSelectedState -> onItemLoaded(uiState.uiMovieItem)
        }
    }

    fun setDefaultState() {
        setScreenForLoading(true)
        setScreenForContent(false)
    }

    private fun setScreenForLoading(isLoaded: Boolean) {
        when (isLoaded) {
            true -> loading.isVisible = isLoaded
            else -> loading.isGone = !isLoaded
        }
    }

    fun setScreenForContent(isLoaded: Boolean) {
        when (isLoaded) {
            true -> binding.contentLayout.isVisible = isLoaded
            else -> binding.contentLayout.isGone = !isLoaded
        }
    }

    private fun setScreenForSuccess(popular: UiPopular) {
        setScreenForLoading(false)
        setScreenForContent(true)
        setIncomingData(popular.results)
    }

    fun setScreenForError(show: Boolean) {
        when (show) {
            true -> {
                setScreenForLoading(false)
                binding.error.apply {
                    isVisible = show
                    setErrorDismissListener()
                }
            }
            else -> {
                binding.error.apply {
                    if (movieAdapter.itemCount == 0) {
                        activity?.finish()
                    } else {
                        isVisible = !show
                        setScreenForContent(true)
                    }
                }
            }
        }
    }

    fun setErrorDismissListener() {
        binding.itemClickListener = OnClickListener { setScreenForError(false) }
    }

    fun onItemClicked(uiPopularItem: UiPopularItem) {
        executeLoad(uiPopularItem.id)
    }

    fun onItemLoaded(uiMovieItem: UiMovieItem) {
        movieItemDialogFragment.liveDataUiState.value = uiMovieItem
        movieItemDialogFragment.show(parentFragmentManager)
    }

    private fun setLastItemListener() {
        binding.rvMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(DIRECTION)) {
                    context?.let { showToast(it) }
                    executeInit((currentPageNum + PAGE_INIT_VALUE).toString())
                }
            }
        })
    }

    private fun showToast(context: Context) {
        Toast.makeText(
            context,
            context.getString(R.string.loading_more),
            Toast.LENGTH_LONG
        ).show()
    }

    companion object {
        const val PAGE_INIT_VALUE = 1
        const val INI_PAGE = "1"
        const val DIRECTION = 1
    }
}