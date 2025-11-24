package com.example.flickipics.ui.fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.flickipics.databinding.ItemRecomendedBinding
import com.squareup.picasso.Picasso

class RecommendedAdapter(private val onClick: (RecommendedDTO) -> Unit = {}) :
    ListAdapter<RecommendedDTO, RecommendedAdapter.RecommendedViewHolder>(Diff()) {

    class Diff : DiffUtil.ItemCallback<RecommendedDTO>() {
        override fun areItemsTheSame(oldItem: RecommendedDTO, newItem: RecommendedDTO): Boolean {
            // If you have a stable unique ID, use it here instead.
            return oldItem.title == newItem.title && oldItem.imageUrl == newItem.imageUrl
        }

        override fun areContentsTheSame(oldItem: RecommendedDTO, newItem: RecommendedDTO): Boolean {
            return oldItem == newItem
        }
    }

    inner class RecommendedViewHolder(val binding: ItemRecomendedBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): RecommendedViewHolder {
        var binding =
            ItemRecomendedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendedViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.textTitle.text = item.title
        holder.binding.textGenre.text = item.genre

        item.imageUrl?.let { imageUrl ->
            Picasso.get().load(imageUrl).into(holder.binding.imagePoster)
        }
        holder.binding.root.setOnClickListener { onClick.invoke(item) }
    }

}