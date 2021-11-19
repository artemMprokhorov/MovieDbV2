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
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.R
import com.example.moviedb.catalog.presentation.MovieIntent
import com.example.moviedb.catalog.presentation.MovieState
import com.example.moviedb.catalog.presentation.MovieViewModel
import com.example.moviedb.catalog.presentation.model.MovieItem
import com.example.moviedb.catalog.presentation.model.Popular
import com.example.moviedb.catalog.presentation.model.PopularItem
import com.example.moviedb.catalog.ui.adapter.MovieAdapter
import com.example.moviedb.catalog.ui.view.ErrorView
import com.example.moviedb.catalog.ui.view.LoadingView
import com.example.moviedb.commons.factory.ViewModelFactory
import com.example.moviedb.commons.mvi.MviUi
import com.example.moviedb.databinding.FragmentMovieCatalogBinding
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@FlowPreview
class MovieCatalogFragment : DaggerFragment(), MviUi<MovieIntent, MovieState> {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var movieAdapter: MovieAdapter

    @Inject
    lateinit var movieItemDialogFragment: MovieItemDialogFragment

    private lateinit var binding: FragmentMovieCatalogBinding

    private lateinit var loading: LoadingView

    private lateinit var error: ErrorView

    private val liveDataOnChangeState: MutableLiveData<PopularItem?> = MutableLiveData()

    private val userIntents: MutableSharedFlow<MovieIntent> = MutableSharedFlow()

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
        subscribeStatesProcessIntents()
        setupObservers()
        onLiveDataSubscribe()
        setLastItemListener()
    }

    override fun intents(): Flow<MovieIntent> = merge(
        getPopularIntent(),
        userIntents.asSharedFlow()
    )

    private fun getPopularIntent(): Flow<MovieIntent> = flow {
        emit(MovieIntent.GetPopularIntent(INI_PAGE))
    }

    private fun subscribeStatesProcessIntents() {
        viewModel.run { viewModel.processIntents(intents()) }
    }

    private fun setupObservers() {
        with(viewModel) { uiStates().onEach { renderStates(it) }.launchIn(lifecycleScope) }
    }

    private fun setupAdapter() {
        binding.rvMovies.adapter = movieAdapter
    }

    private fun liveData(): LiveData<PopularItem?> = liveDataOnChangeState

    private fun onLiveDataSubscribe() {
        liveData().observe(this, {
            if (it != null) {
                onItemClicked(it)
            }
        })
    }

    private fun setIncomingData(popular: List<PopularItem>?) {
        when (popular) {
            null -> setScreenForError(true)
            else -> movieAdapter.setData(popular, liveDataOnChangeState)
        }
    }

    override fun renderStates(uiState: MovieState) {
        when (uiState) {
            MovieState.DefaultState -> setDefaultState()
            MovieState.LoadingState -> setScreenForLoading(true)
            is MovieState.SuccessPopularState -> {
                setScreenForSuccess(uiState.popular)
                currentPageNum = uiState.popular.page
            }
            is MovieState.ErrorState -> {
                setScreenForContent(false)
                setScreenForError(true)
            }
            is MovieState.SuccessItemSelectedState -> onItemLoaded(uiState.movieItem)
        }
    }

    private fun setDefaultState() {
        setScreenForLoading(true)
        setScreenForContent(false)
    }

    private fun setScreenForLoading(isLoaded: Boolean) {
        when (isLoaded) {
            true -> loading.isVisible = isLoaded
            else -> loading.isGone = !isLoaded
        }
    }

    private fun setScreenForContent(isLoaded: Boolean) {
        when (isLoaded) {
            true -> binding.contentLayout.isVisible = isLoaded
            else -> binding.contentLayout.isGone = !isLoaded
        }
    }

    private fun setScreenForSuccess(popular: Popular) {
        setScreenForLoading(false)
        setScreenForContent(true)
        setIncomingData(popular.results)
    }

    private fun setScreenForError(show: Boolean) {
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

    private fun setErrorDismissListener() {
        binding.itemClickListener = OnClickListener { setScreenForError(false) }
    }

    private fun onItemClicked(popularItem: PopularItem) {
        viewLifecycleOwner.lifecycleScope.launch {
            userIntents.emit(MovieIntent.GetItemSelectedIntent(popularItem.id))
        }
    }

    private fun onItemLoaded(movieItem: MovieItem) {
        movieItemDialogFragment.liveDataUiState.value = movieItem
        movieItemDialogFragment.show(parentFragmentManager)
    }

    private fun setLastItemListener() {
        binding.rvMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(DIRECTION)) {
                    context?.let { showToast(it) }
                    currentPageNum += PAGE_INIT_VALUE
                    viewLifecycleOwner.lifecycleScope.launch {
                        userIntents.emit(MovieIntent.GetPopularIntent((currentPageNum).toString()))
                    }
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