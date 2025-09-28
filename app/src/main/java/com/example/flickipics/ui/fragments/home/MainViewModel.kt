package com.example.flickipics.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flickipics.data.repo.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _movieRecommendedFlow = MutableStateFlow(mutableListOf<RecomendedDTO>())
    val movieRecommendedFlow: StateFlow<List<RecomendedDTO>> = _movieRecommendedFlow.asStateFlow()

    private val _movieTopSearchFlow = MutableStateFlow(mutableListOf<TopSearchDTO>())
    val movieTopSearchFlow: StateFlow<List<TopSearchDTO>> = _movieTopSearchFlow.asStateFlow()

    fun fetchRecommendedMovie() {
        viewModelScope.launch {
            val movieList = movieRepository.fetchRecommendedMovieList()
            _movieRecommendedFlow.value = movieList.toMutableList()
        }
    }

    fun fetchTopSearchMovie() {
        viewModelScope.launch {
            val movieList = movieRepository.fetchTopSearchMovieList()
            _movieTopSearchFlow.value = movieList.toMutableList()
        }
    }

}