package com.example.flickipics.ui.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flickipics.R
import com.example.flickipics.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    var binding:FragmentSearchBinding?=null
    var searchAdapter:SearchAdapter?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSearchBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var items= listOf(

            SearchDTO(R.drawable.parasite_movie,"Parasite","Drama"),
            SearchDTO(R.drawable.parasite_movie,"Parasite","Drama"),
            SearchDTO(R.drawable.parasite_movie,"Parasite","Drama"),
            SearchDTO(R.drawable.parasite_movie,"Parasite","Drama"),
            SearchDTO(R.drawable.parasite_movie,"Parasite","Drama"),
            SearchDTO(R.drawable.parasite_movie,"Parasite","Drama"),
            SearchDTO(R.drawable.parasite_movie,"Parasite","Drama"),
            SearchDTO(R.drawable.parasite_movie,"Parasite","Drama"),
            SearchDTO(R.drawable.parasite_movie,"Parasite","Drama"),
            SearchDTO(R.drawable.parasite_movie,"Parasite","Drama"),
            SearchDTO(R.drawable.parasite_movie,"Parasite","Drama"),
            SearchDTO(R.drawable.parasite_movie,"Parasite","Drama"),
            SearchDTO(R.drawable.parasite_movie,"Parasite","Drama")

        )
        var adapter=SearchAdapter(items)
        binding?.recyclerView?.layoutManager = GridLayoutManager(requireContext(), 3,)
        binding?.recyclerView?.adapter=adapter
    }

}