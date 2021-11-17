package com.example.moviedb.catalog.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.BuildConfig
import com.example.moviedb.catalog.presentation.model.UiPopularItem
import com.example.moviedb.catalog.ui.util.Constants.PRIMARY_OVERRIDED_HEIGHT
import com.example.moviedb.catalog.ui.util.Constants.PRIMARY_OVERRIDED_WIDTH
import com.example.moviedb.catalog.ui.util.ImageLoader
import com.example.moviedb.databinding.ViewMovieItemBinding
import javax.inject.Inject


class MovieAdapter @Inject constructor(private val imageLoader: ImageLoader) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    private var liveDataOnChangeState: MutableLiveData<UiPopularItem?> = MutableLiveData()
    private var popularList: MutableList<UiPopularItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ViewMovieItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return popularList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val popularItem = popularList[position]
        val imageLoader = imageLoader

        holder.bind(
            itemListener = View.OnClickListener { liveDataOnChangeState.postValue(popularItem) },
            item = popularItem,
            imageLoader = imageLoader
        )
    }

    fun setData(
        messages: List<UiPopularItem>,
        liveDataOnChangeState: MutableLiveData<UiPopularItem?>
    ) {
        this.popularList.addAll(messages)
        this.liveDataOnChangeState = liveDataOnChangeState
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ViewMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            itemListener: View.OnClickListener,
            item: UiPopularItem,
            imageLoader: ImageLoader
        ) {
            binding.apply {
                movieItem = item
                setImage(imageLoader, previewImg, item)
                itemClickListener = itemListener
                executePendingBindings()
            }
        }

        private fun setImage(
            imageLoader: ImageLoader,
            previewImg: ImageView,
            item: UiPopularItem
        ) {
            item.backdropPath.let {
                imageLoader.setImage(
                    previewImg, BuildConfig.API_IMG, it,
                    PRIMARY_OVERRIDED_WIDTH, PRIMARY_OVERRIDED_HEIGHT
                )
            }
        }
    }
}

