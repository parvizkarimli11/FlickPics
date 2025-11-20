package com.example.flickipics.ui.fragments.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flickipics.R
import com.example.flickipics.data.repo.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _searchFlow = MutableStateFlow(mutableListOf<SearchDTO>())
    val searchFlow: StateFlow<List<SearchDTO>> = _searchFlow.asStateFlow()

    fun fetchAllData() {
        viewModelScope.launch {
            val movieList = movieRepository.fetchRecommendedMovieList()
            val searchList = movieList.map {
                SearchDTO(
                    imageResId = it.imageResId ?: R.drawable.parasite_movie,
                    title = it.title,
                    genre = it.genre ?: "",
                    imageUrl = it.imageUrl
                )
            }
            _searchFlow.value = searchList.toMutableList()
        }
    }

    fun searchData(query: String = "") {
        if (query.isEmpty()) {
            fetchAllData()
        } else {
            viewModelScope.launch {
                val movieList = movieRepository.fetchRecommendedMovieList()
                val filteredList = movieList.filter {
                    it.title.contains(query, ignoreCase = true) ||
                            it.genre?.contains(query, ignoreCase = true) == true
                }.map {
                    SearchDTO(
                        imageResId = it.imageResId ?: R.drawable.parasite_movie,
                        title = it.title,
                        genre = it.genre ?: "",
                        imageUrl = it.imageUrl
                    )
                }
                _searchFlow.value = filteredList.toMutableList()
            }
        }
    }

}