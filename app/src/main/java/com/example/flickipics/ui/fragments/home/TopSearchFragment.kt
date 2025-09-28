package com.example.flickipics.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flickipics.R
import com.example.flickipics.databinding.FragmentTopSearchBinding


class TopSearchFragment : Fragment() {

    var binding:FragmentTopSearchBinding?= null
    var topSearchAdapter:TopSearchAdapter?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentTopSearchBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var items= listOf(
            TopSearchDTO("Bridgerton", "Drama", R.drawable.movie1),
            TopSearchDTO("Bridgerton", "Drama", R.drawable.movie1),
            TopSearchDTO("Bridgerton", "Drama", R.drawable.movie1),
            TopSearchDTO("Bridgerton", "Drama", R.drawable.movie1),
            TopSearchDTO("Bridgerton", "Drama", R.drawable.movie1),
            TopSearchDTO("Bridgerton", "Drama", R.drawable.movie1),
            TopSearchDTO("Bridgerton", "Drama", R.drawable.movie1),
            TopSearchDTO("Bridgerton", "Drama", R.drawable.movie1),
            TopSearchDTO("Bridgerton", "Drama", R.drawable.movie1),
            TopSearchDTO("Bridgerton", "Drama", R.drawable.movie1),
            TopSearchDTO("Bridgerton", "Drama", R.drawable.movie1),

        )

        val adapter = TopSearchAdapter()
        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerView?.adapter = adapter

    }


    }
