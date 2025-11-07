package com.example.flickipics.data.repo

import com.example.flickipics.ui.fragments.home.RecomendedDTO
import com.example.flickipics.ui.fragments.home.TopSearchDTO
import com.example.flickipics.ui.fragments.search.SearchDTO

interface MovieRepository {

    suspend fun fetchRecommendedMovieList(): List<RecomendedDTO>
    suspend fun fetchTopSearchMovieList(): List<TopSearchDTO>
    suspend fun fetchSearchMovieList():List<SearchDTO>


}