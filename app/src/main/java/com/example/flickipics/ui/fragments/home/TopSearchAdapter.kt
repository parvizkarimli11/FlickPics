package com.example.flickipics.ui.fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.flickipics.databinding.ItemTopSearchBinding
import com.squareup.picasso.Picasso

class TopSearchAdapter(private val onClick: (TopSearchDTO) -> Unit = {}) :
    ListAdapter<TopSearchDTO, TopSearchAdapter.TopSearchViewHolder>(Diff()) {

    class Diff : DiffUtil.ItemCallback<TopSearchDTO>() {
        override fun areItemsTheSame(oldItem: TopSearchDTO, newItem: TopSearchDTO): Boolean {
            // If you have a stable unique ID, use it here instead.
            return oldItem.title == newItem.title && oldItem.imageUrl == newItem.imageUrl
        }

        override fun areContentsTheSame(oldItem: TopSearchDTO, newItem: TopSearchDTO): Boolean {
            return oldItem == newItem
        }
    }

    inner class TopSearchViewHolder(val binding: ItemTopSearchBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopSearchViewHolder {
        var binding =
            ItemTopSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopSearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopSearchViewHolder, position: Int) {
        val item = getItem(position)
        item.imageUrl?.let { imageUrl ->
            Picasso.get().load(imageUrl).into(holder.binding.imageViewMovie)
        }
        holder.binding.textViewMovieTitle.text = item.title
        holder.binding.textViewMovieGenre.text = item.genre
    }
}