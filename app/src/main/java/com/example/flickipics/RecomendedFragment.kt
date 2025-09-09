package com.example.flickipics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flickipics.databinding.FragmentMainBinding
import com.example.flickipics.databinding.FragmentRecomendedBinding


class RecomendedFragment : Fragment() {

    var binding: FragmentRecomendedBinding? = null
    var recomendedAdapter: RecomendedAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRecomendedBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {




        val movieList = listOf(
            RecomendedDTO(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                genre = "Drama"
            ),
            RecomendedDTO(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                genre = "Drama"
            ),
            RecomendedDTO(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                genre = "Drama"
            ),
            RecomendedDTO(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                genre = "Drama"
            ),
            RecomendedDTO(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                genre = "Drama"

            ),RecomendedDTO(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                genre = "Drama"

            ),RecomendedDTO(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                genre = "Drama"

            ),RecomendedDTO(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                genre = "Drama"
            ),RecomendedDTO(
                imageResId = R.drawable.movie,
                title = "The Greatest Showman",
                genre = "Drama"
            )


        )

        recomendedAdapter = RecomendedAdapter(movieList)

        binding?.recyclerView?.layoutManager = GridLayoutManager(
            requireContext(),
             3
        )
        binding?.recyclerView?.adapter = recomendedAdapter
    }



    }
