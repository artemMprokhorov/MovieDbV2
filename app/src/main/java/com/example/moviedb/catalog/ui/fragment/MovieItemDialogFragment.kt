package com.example.moviedb.catalog.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviedb.BuildConfig
import com.example.moviedb.R
import com.example.moviedb.catalog.presentation.model.UiMovieItem
import com.example.moviedb.catalog.ui.util.Constants.POSTER_OVERRIDED_HEIGHT
import com.example.moviedb.catalog.ui.util.Constants.POSTER_OVERRIDED_WIDTH
import com.example.moviedb.catalog.ui.util.ImageLoader
import com.example.moviedb.databinding.FragmentMovieItemDialogBinding


class MovieItemDialogFragment(private val imageLoader: ImageLoader?) : AppCompatDialogFragment() {

    private var binding: FragmentMovieItemDialogBinding? = null
    val liveDataUiState = MutableLiveData<UiMovieItem>()
    private fun liveData(): LiveData<UiMovieItem> = liveDataUiState
    val toolbarTitle: ObservableField<String> = ObservableField("")

    companion object {

        fun newInstance(
        ): MovieItemDialogFragment {
            val dialog = MovieItemDialogFragment(null)
            dialog.isCancelable = false
            return dialog
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMovieItemDialogBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_movie_item_dialog,
                container,
                false
            )
        val view: View = binding.root
        binding.fragment = this
        this.binding = binding
        binding.itemClickListener = View.OnClickListener { onDismiss() }
        return view
    }

    private fun setContent(uiMovieItem: UiMovieItem) {
        binding?.movieItem = uiMovieItem
        toolbarTitle.set(uiMovieItem.title)
        uiMovieItem.posterPath.let {
            binding?.previewImg?.let { it1 ->
                imageLoader?.setImage(
                    it1, BuildConfig.API_IMG, it, POSTER_OVERRIDED_WIDTH, POSTER_OVERRIDED_HEIGHT
                )
            }
        }
    }

    fun onDismiss() {
        dismiss()
    }

    fun show(
        manager: FragmentManager
    ) {
        if (!isVisible) show(manager, MovieItemDialogFragment::class.simpleName)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.AppTheme)
        onLiveDataSubscribe()
    }


    private fun onLiveDataSubscribe() {
        liveData().observe(this, Observer<UiMovieItem?> {
            if (it != null) {
                setContent(it)
            }
        })
    }
}