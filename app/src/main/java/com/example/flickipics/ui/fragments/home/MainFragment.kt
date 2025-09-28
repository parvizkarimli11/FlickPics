package com.example.flickipics.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flickipics.R
import com.example.flickipics.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private var recommendedAdapter: RecommendedAdapter? = null
    private var topSearchAdapter: TopSearchAdapter? = null
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRv()
        initListeners()
        fetchDatas()
    }

    private fun initListeners() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.movieRecommendedFlow.collect { movies ->
                    handleRecommendedMovieResponse(movies)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.movieTopSearchFlow.collect { movies ->
                    handleTopSearchMovieResponse(movies)
                }
            }
        }

        binding?.texViewSeaAll?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_recomendedFragment)
        }

        binding?.textViewSeaAll1?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_topSearchFragment)
        }
    }

    private fun fetchDatas() {
        mainViewModel.fetchRecommendedMovie()
        mainViewModel.fetchTopSearchMovie()
    }

    private fun initRv() {
        //recommended
        recommendedAdapter = RecommendedAdapter({

        })
        binding?.recyclerView?.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.HORIZONTAL, false
        )
        binding?.recyclerView?.adapter = recommendedAdapter

        //top search
        topSearchAdapter = TopSearchAdapter({

        })
        binding?.rvTopSearch?.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.VERTICAL, false
        )
        binding?.rvTopSearch?.adapter = topSearchAdapter
    }

    private fun handleRecommendedMovieResponse(items: List<RecomendedDTO>) {
        recommendedAdapter?.submitList(items)
    }

    private fun handleTopSearchMovieResponse(items: List<TopSearchDTO>) {
        topSearchAdapter?.submitList(items)
    }

}