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
import com.example.flickipics.data.api.NetworkUtil
import com.example.flickipics.data.response.MovieListResponse
import com.example.flickipics.databinding.FragmentMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment : Fragment() {

    var binding: FragmentMainBinding? = null
    var recomendedAdapter: RecomendedAdapter? = null
    var seeAllTextView: TextView? = null
    var seaAllTextView1: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        seeAllTextView = binding?.texViewSeaAll

        seeAllTextView?.setOnClickListener {

            findNavController().navigate(R.id.action_mainFragment_to_recomendedFragment)

        }


//        val movieList = listOf(
//            RecomendedDTO(
//                imageResId = R.drawable.movie, title = "The Greatest Showman", genre = "Drama"
//            ), RecomendedDTO(
//                imageResId = R.drawable.movie, title = "The Greatest Showman", genre = "Drama"
//            ), RecomendedDTO(
//                imageResId = R.drawable.movie, title = "The Greatest Showman", genre = "Drama"
//            ), RecomendedDTO(
//                imageResId = R.drawable.movie, title = "The Greatest Showman", genre = "Drama"
//            ), RecomendedDTO(
//                imageResId = R.drawable.movie, title = "The Greatest Showman", genre = "Drama"
//            )
//
//        )


        seaAllTextView1 = binding?.textViewSeaAll1

        seaAllTextView1?.setOnClickListener {

            findNavController().navigate(R.id.action_mainFragment_to_topSearchFragment)

        }

        NetworkUtil.usersApi.fetchMovieList().enqueue(object : Callback<MovieListResponse> {
            override fun onResponse(
                call: Call<MovieListResponse?>, response: Response<MovieListResponse?>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        handleResponse(it)
                    }
                }
            }

            override fun onFailure(
                call: Call<MovieListResponse?>, t: Throwable
            ) {

            }

        })
    }

    private fun handleResponse(body: MovieListResponse) {
        val newMovieList = mutableListOf<RecomendedDTO>()
        body.docs?.forEach { movie ->
            newMovieList.add(
                RecomendedDTO(
                    title = movie.name ?: "Test", genre = "", imageResId = R.drawable.movie
                )
            )
        }
        recomendedAdapter = RecomendedAdapter(newMovieList)
        binding?.recyclerView?.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.HORIZONTAL, false
        )
        binding?.recyclerView?.adapter = recomendedAdapter


    }

}