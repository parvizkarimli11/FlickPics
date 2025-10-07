package com.example.flickipics.ui.fragments.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.flickipics.databinding.ItemSearchBinding

class SearchAdapter(private val items: List<SearchDTO>) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    inner class SearchViewHolder(val binding: ItemSearchBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {

        val item = items[position]
        holder.binding.parasiteMovie.setImageResource(item.imageResId)
        holder.binding.textViewMovieTitle.text = item.title
        holder.binding.textViewMovieGenre.text = item.genre

    }

}