package com.example.moviedb.catalog.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.R
import com.example.moviedb.catalog.presentation.intent.MovieUserIntent
import com.example.moviedb.catalog.presentation.model.UiMovieItem
import com.example.moviedb.catalog.presentation.model.UiPopular
import com.example.moviedb.catalog.presentation.model.UiPopularItem
import com.example.moviedb.catalog.presentation.state.MovieState
import com.example.moviedb.catalog.presentation.viewmodel.MovieViewModel
import com.example.moviedb.catalog.ui.activity.Constants.DIRECTION
import com.example.moviedb.catalog.ui.activity.Constants.INI_PAGE
import com.example.moviedb.catalog.ui.activity.Constants.LOADING_MORE
import com.example.moviedb.catalog.ui.activity.Constants.PAGE_INIT_VALUE
import com.example.moviedb.catalog.ui.adapter.MovieAdapter
import com.example.moviedb.catalog.ui.fragment.MovieItemDialogFragment
import com.example.moviedb.catalog.ui.view.ErrorView
import com.example.moviedb.catalog.ui.view.LoadingView
import com.example.moviedb.common.factory.ViewModelFactory
import com.example.moviedb.common.presentation.mvi.MviUi
import com.example.moviedb.databinding.ActivityMovieBinding
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject


class MovieActivity : DaggerAppCompatActivity(), MviUi<MovieUserIntent, MovieState> {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var movieAdapter: MovieAdapter

    @Inject
    lateinit var movieItemDialogFragment: MovieItemDialogFragment

    private lateinit var loading: LoadingView

    private lateinit var error: ErrorView

    lateinit var binding: ActivityMovieBinding

    private val liveDataOnChangeState: MutableLiveData<UiPopularItem?> = MutableLiveData()

    val viewModel by viewModels<MovieViewModel> { viewModelFactory }

    private val initialIntent = PublishSubject.create<MovieUserIntent.InitialUserIntent>()

    private val loadingIntent = PublishSubject.create<MovieUserIntent.MovieLoadingUserIntent>()

    var currentPageNum: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupActivity()
        subscribeUiStatesAndProcessUserIntents()
        setupAdapter()
        onLiveDataSubscribe()
        executeInit(INI_PAGE)
        setLastItemListener()
    }

    private fun setupActivity() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        loading = binding.loading
        error = binding.error
    }

    private fun setupAdapter() {
        binding.rvMovies.adapter = movieAdapter
    }

    private fun liveData(): LiveData<UiPopularItem?> = liveDataOnChangeState

    private fun onLiveDataSubscribe() {
        liveData().observe(this, Observer {
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
        viewModel.liveData().observe(this, Observer<MovieState> { uiState ->
            uiState?.let { renderUiStates(it) }
        })
    }

    override fun renderUiStates(uiState: MovieState) {
        when (uiState) {
            MovieState.Default -> setDefaultState()
            MovieState.Loading -> setScreenForLoading(uiState.isLoading)
            is MovieState.SuccessState -> {
                setScreenForSuccess(uiState.popular)
                currentPageNum = uiState.popular.page
            }
            is MovieState.Error -> {
                setScreenForContent(false)
                setScreenForError(true)
            }

            is MovieState.SuccessMovieLoading -> onItemLoaded(uiState.uiMovieItem)
        }
    }

    fun setDefaultState() {
        setScreenForLoading(true)
        setScreenForContent(false)
    }

    private fun setScreenForLoading(isLoading: Boolean) {
        if (isLoading) {
            loading.apply {
                visibility = View.VISIBLE
            }

        } else {
            loading.apply {
                visibility = View.GONE
            }
        }
    }

    fun setScreenForContent(isLoading: Boolean) {
        if (isLoading) {
            binding.contentLayout.apply {
                visibility = View.VISIBLE
            }

        } else {
            binding.contentLayout.apply {
                visibility = View.GONE
            }
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
                    visibility = View.VISIBLE
                    setErrorDismissListener()
                }
            }
            else -> {
                binding.error.apply {
                    if (movieAdapter.itemCount == 0) {
                        finish()
                    } else {
                        visibility = View.INVISIBLE
                        setScreenForContent(true)
                    }
                }
            }
        }
    }


    fun setErrorDismissListener() {
        binding.itemClickListener = View.OnClickListener { setScreenForError(false) }
    }


    fun onItemClicked(uiPopularItem: UiPopularItem) {
        executeLoad(uiPopularItem.id)
    }

    fun onItemLoaded(uiMovieItem: UiMovieItem) {
        movieItemDialogFragment.liveDataUiState.value = uiMovieItem
        movieItemDialogFragment.show(supportFragmentManager)
    }


    private fun setLastItemListener() {

        binding.rvMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(DIRECTION)) {
                    Toast.makeText(this@MovieActivity, LOADING_MORE, Toast.LENGTH_LONG).show()
                    executeInit((currentPageNum + PAGE_INIT_VALUE).toString())
                }
            }
        })
    }

}
