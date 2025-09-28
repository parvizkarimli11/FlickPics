package com.example.flickipics.data.repo

import com.example.flickipics.ui.fragments.home.RecomendedDTO
import com.example.flickipics.ui.fragments.home.TopSearchDTO

interface MovieRepository {

    suspend fun fetchRecommendedMovieList(): List<RecomendedDTO>
    suspend fun fetchTopSearchMovieList(): List<TopSearchDTO>

}