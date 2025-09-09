package com.example.flickipics.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flickipics.R
import com.example.flickipics.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    var binding: FragmentMainBinding? = null
    var recomendedAdapter: RecomendedAdapter? = null
    var seeAllTextView:TextView?=null
    var seaAllTextView1:TextView?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        seeAllTextView=binding?.texViewSeaAll

        seeAllTextView?.setOnClickListener {

            findNavController().navigate(R.id.action_mainFragment_to_recomendedFragment)

        }


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
            )

        )

        recomendedAdapter = RecomendedAdapter(movieList)
        binding?.recyclerView?.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding?.recyclerView?.adapter = recomendedAdapter


        seaAllTextView1=binding?.textViewSeaAll1

        seaAllTextView1?.setOnClickListener {

            findNavController().navigate(R.id.action_mainFragment_to_topSearchFragment)

        }
    }




}