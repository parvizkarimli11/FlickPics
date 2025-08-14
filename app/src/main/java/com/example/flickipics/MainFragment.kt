package com.example.flickipics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flickipics.databinding.FragmentMainBinding
import com.example.flickipics.databinding.ItemRecomendedBinding


class MainFragment : Fragment() {

    var binding: FragmentMainBinding? = null
    var recomendedAdapter: RecomendedAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val movieList = listOf(
            RecomendedDT(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                country = "USA"
            ),
            RecomendedDT(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                country = "USA"
            ),
            RecomendedDT(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                country = "USA"
            ),
            RecomendedDT(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                country = "USA"
            ),
            RecomendedDT(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                country = "USA"
            ),
            RecomendedDT(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                country = "USA"
            ),
            RecomendedDT(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                country = "USA"
            ),
            RecomendedDT(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                country = "USA"
            ),
            RecomendedDT(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                country = "USA"
            ),
            RecomendedDT(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                country = "USA"
            )
        )

        recomendedAdapter = RecomendedAdapter(movieList)
        binding?.recyclerView?.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding?.recyclerView?.adapter = recomendedAdapter
    }


}