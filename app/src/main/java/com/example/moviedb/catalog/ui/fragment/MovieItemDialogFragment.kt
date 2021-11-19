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
import com.example.moviedb.R
import com.example.moviedb.catalog.presentation.model.MovieItem
import com.example.moviedb.commons.extentions.getFromResId
import com.example.moviedb.commons.extentions.setImageFromUrl
import com.example.moviedb.databinding.FragmentMovieItemDialogBinding

class MovieItemDialogFragment() : AppCompatDialogFragment() {

    private var binding: FragmentMovieItemDialogBinding? = null
    val liveDataUiState = MutableLiveData<MovieItem>()
    private fun liveData(): LiveData<MovieItem> = liveDataUiState
    val toolbarTitle: ObservableField<String> = ObservableField("")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

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

    private fun setContent(item: MovieItem) {
        binding?.apply {
            movieItem = item
            toolbarTitle.set(item.title)

            R.drawable.ic_error.getFromResId(previewImg.context)?.let {
                previewImg.setImageFromUrl(
                    imgSource = item.backdropPath,
                    useCache = true,
                    targetWidth = POSTER_OVERRIDE_WIDTH,
                    targetHeight = POSTER_OVERRIDE_HEIGHT,
                    placeholder = it
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
        liveData().observe(this, { item ->
            if (item != null) {
                setContent(item)
            }
        })
    }

    companion object {

        fun newInstance(
        ): MovieItemDialogFragment {
            val dialog = MovieItemDialogFragment()
            dialog.isCancelable = false
            return dialog
        }

        const val POSTER_OVERRIDE_WIDTH = 300
        const val POSTER_OVERRIDE_HEIGHT = 350
    }
}