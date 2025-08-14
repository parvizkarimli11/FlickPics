package com.example.flickipics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.flickipics.databinding.ItemRecomendedBinding

class RecomendedAdapter(private val items: List<RecomendedDT>) :
    RecyclerView.Adapter<RecomendedAdapter.RecomendedViewHolder>() {

    inner class RecomendedViewHolder(val binding: ItemRecomendedBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecomendedAdapter.RecomendedViewHolder {
        var binding =
            ItemRecomendedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecomendedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecomendedViewHolder, position: Int) {
        var item = items[position]
        holder.binding.imagePoster.setImageResource(R.drawable.movie)
        holder.binding.textTitle.text = item.title
        holder.binding.textCountry.text = item.country
    }

    override fun getItemCount(): Int {
        return items.size
    }


}