package com.example.moviedb.catalog.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.R
import com.example.moviedb.catalog.presentation.model.UiPopularItem
import com.example.moviedb.commons.extentions.getFromResId
import com.example.moviedb.commons.extentions.setImageFromUrl
import com.example.moviedb.databinding.ViewMovieItemBinding
import javax.inject.Inject


class MovieAdapter @Inject constructor() :
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

    override fun getItemCount(): Int = popularList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val popularItem = popularList[position]

        holder.bind(
            itemListener = { liveDataOnChangeState.postValue(popularItem) },
            item = popularItem
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
            item: UiPopularItem
        ) {
            binding.apply {
                movieItem = item
                setImage(previewImg, item)
                itemClickListener = itemListener
                executePendingBindings()
            }
        }

        private fun setImage(
            previewView: ImageView,
            item: UiPopularItem
        ) {
            R.drawable.ic_error.getFromResId(previewView.context)?.let {
                previewView.setImageFromUrl(
                    imgSource = item.backdropPath,
                    useCache = true,
                    targetWidth = PRIMARY_OVERRIDE_WIDTH,
                    targetHeight = PRIMARY_OVERRIDE_HEIGHT,
                    placeholder = it
                )
            }
        }
    }

    companion object {
        const val PRIMARY_OVERRIDE_WIDTH = 200
        const val PRIMARY_OVERRIDE_HEIGHT = 125
    }
}

