package com.example.flickipics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flickipics.databinding.FragmentMainBinding
import com.example.flickipics.databinding.ItemTopSearchBinding

class TopSearchAdapter(private val items:List<TopSearchDTO>)
    :RecyclerView.Adapter<TopSearchAdapter.TopSearchViewHolder>() {

    inner class TopSearchViewHolder(val binding:ItemTopSearchBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopSearchViewHolder {
        var binding=ItemTopSearchBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TopSearchViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: TopSearchViewHolder, position: Int) {
        val item=items[position]
        holder.binding.imageViewMovie.setImageResource(item.imageResId)
        holder.binding.textViewMovieTitle.text=item.title
        holder.binding.textViewMovieGenre.text=item.genre
    }
}