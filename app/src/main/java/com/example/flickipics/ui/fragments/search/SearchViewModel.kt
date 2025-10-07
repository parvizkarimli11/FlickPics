package com.example.flickipics.ui.fragments.search

import androidx.lifecycle.ViewModel
import com.example.flickipics.R
import com.example.flickipics.data.repo.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _searchFlow = MutableStateFlow(mutableListOf<SearchDTO>())
    val searchFlow: StateFlow<List<SearchDTO>> = _searchFlow.asStateFlow()

    fun searchData(query: String = "") {
        if (query.isEmpty()) {
            var items = mutableListOf(
                SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
                SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
                SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
                SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
                SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
                SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
                SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
                SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
                SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
                SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
                SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
                SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
                SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama")
            )
            _searchFlow.value = items
        } else {
            //search
            var items = mutableListOf(
                SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama")
            )
            //result
            _searchFlow.value = items
        }
    }

    fun fetchAllData() {
        var items = mutableListOf(
            SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
            SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
            SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
            SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
            SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
            SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
            SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
            SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
            SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
            SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
            SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
            SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama"),
            SearchDTO(R.drawable.parasite_movie, "Parasite", "Drama")
        )
        _searchFlow.value = items
    }

}