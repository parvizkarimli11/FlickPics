package com.example.flickipics.ui.fragments.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.flickipics.databinding.ItemSearchBinding
import com.squareup.picasso.Picasso

class SearchAdapter(private val onClick: (SearchDTO) -> Unit = {}) :
    ListAdapter<SearchDTO, SearchAdapter.SearchViewHolder>(Diff()) {

    class Diff : DiffUtil.ItemCallback<SearchDTO>() {
        override fun areItemsTheSame(oldItem: SearchDTO, newItem: SearchDTO): Boolean {
            return oldItem.title == newItem.title && oldItem.imageUrl == newItem.imageUrl
        }

        override fun areContentsTheSame(oldItem: SearchDTO, newItem: SearchDTO): Boolean {
            return oldItem == newItem
        }
    }

    inner class SearchViewHolder(val binding: ItemSearchBinding) :
        ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.textViewMovieTitle.text = item.title
        holder.binding.textViewMovieGenre.text = item.genre

        item.imageUrl?.let { imageUrl ->
            Picasso.get().load(imageUrl).into(holder.binding.parasiteMovie)
        } ?: run {
            holder.binding.parasiteMovie.setImageResource(item.imageResId)
        }

        holder.binding.root.setOnClickListener { onClick.invoke(item) }
    }

}