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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flickipics.databinding.FragmentTopSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TopSearchFragment : Fragment() {

    private var binding: FragmentTopSearchBinding? = null
    private var topSearchAdapter: TopSearchAdapter? = null
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopSearchBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRv()
        initListeners()
        mainViewModel.fetchTopSearchMovie()
    }

    private fun initRv() {
        topSearchAdapter = TopSearchAdapter({})
        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerView?.adapter = topSearchAdapter
    }

    private fun initListeners() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainViewModel.movieTopSearchFlow.collect { movies ->
                    handleTopSearchMovieResponse(movies)
                }
            }
        }
    }

    private fun handleTopSearchMovieResponse(items: List<TopSearchDTO>) {
        topSearchAdapter?.submitList(items)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}