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
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flickipics.R
import com.example.flickipics.databinding.FragmentRecomendedBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.getValue

@AndroidEntryPoint
class RecommendedFragment : Fragment() {

    private var binding: FragmentRecomendedBinding? = null
    private var recommendedAdapter: RecommendedAdapter? = null
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecomendedBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        initRv()
        mainViewModel.fetchRecommendedMovie()
    }

    private fun initRv() {
        recommendedAdapter = RecommendedAdapter({

        })

        binding?.recyclerView?.layoutManager = GridLayoutManager(
            requireContext(),
            3
        )
        binding?.recyclerView?.adapter = recommendedAdapter
    }

    private fun initListeners() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.movieRecommendedFlow.collect { movies ->
                    handleRecommendedMovieResponse(movies)
                }
            }
        }
    }

    private fun handleRecommendedMovieResponse(items: List<RecomendedDTO>) {
        recommendedAdapter?.submitList(items)
    }

}
