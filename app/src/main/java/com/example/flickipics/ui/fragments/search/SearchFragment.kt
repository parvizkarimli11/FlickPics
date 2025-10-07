package com.example.flickipics.ui.fragments.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flickipics.R
import com.example.flickipics.databinding.FragmentSearchBinding
import com.example.flickipics.ui.fragments.home.MainViewModel
import com.google.android.material.internal.ViewUtils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.getValue

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var binding: FragmentSearchBinding? = null
    private var searchAdapter: SearchAdapter? = null
    private val searchViewModel: SearchViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        binding?.recyclerView?.layoutManager = GridLayoutManager(requireContext(), 3)

        val editText = binding?.searchLayout?.editText ?: return
        editText.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val query = v.text?.toString()?.trim().orEmpty()
                performSearch(query)
                true
            } else false
        }

        searchViewModel.fetchAllData()
    }

    private fun initListeners() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                searchViewModel.searchFlow.collect { movies ->
                    searchAdapter = SearchAdapter(movies)
                    binding?.recyclerView?.adapter = searchAdapter
                }
            }
        }
    }

    private fun performSearch(query: String) {
        searchViewModel.searchData(query)
    }

}