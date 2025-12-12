package com.example.flickipics.data.repo

import android.content.Context
import com.example.flickipics.R
import com.example.flickipics.data.api.MovieService
import com.example.flickipics.data.response.MovieListResponse
import com.example.flickipics.data.di.IoDispatcher
import com.example.flickipics.ui.fragments.home.RecommendedDTO
import com.example.flickipics.ui.fragments.home.TopSearchDTO
import com.example.flickipics.ui.fragments.search.SearchDTO
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    @IoDispatcher private val io: CoroutineDispatcher,
    @ApplicationContext private val context: Context
) : MovieRepository {

    override suspend fun fetchRecommendedMovieList(): List<RecommendedDTO> = withContext(io) {
        try {
            val resp = movieService.fetchMovieList()
            if (resp.isSuccessful) {
                val body = resp.body() ?: return@withContext emptyList()
                handleRecommendedResponse(body)
            } else {
                emptyList()
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            // log e
            emptyList()
        } catch (e: Exception) {
            e.printStackTrace()
            // log e (IO, parsing, etc.)
            emptyList()
        }
    }

    override suspend fun fetchTopSearchMovieList(): List<TopSearchDTO> = withContext(io) {
        try {
            val resp = movieService.fetchMovieList()
            if (resp.isSuccessful) {
                val body = resp.body() ?: return@withContext emptyList()
                handleTopSearchResponse(body)
            } else {
                emptyList()
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            // log e
            emptyList()
        } catch (e: Exception) {
            e.printStackTrace()
            // log e (IO, parsing, etc.)
            emptyList()
        }
    }

    override suspend fun fetchSearchMovieList(): List<SearchDTO> {
        TODO("Not yet implemented")
    }


    private fun handleRecommendedResponse(body: MovieListResponse): List<RecommendedDTO> {
        val newMovieList = mutableListOf<RecommendedDTO>()
        body.docs?.forEach { movie ->

            val stringBuilder = StringBuilder()
            movie.genres?.forEach {
                stringBuilder.append(it.name).append(" ")
            }

            newMovieList.add(
                RecommendedDTO(
                    title = movie.name ?: "Test",
                    genre = stringBuilder.toString(),
                    imageResId = R.drawable.movie,
                    imageUrl = movie.poster?.previewUrl
                )
            )
        }
        return newMovieList
    }

    private fun handleTopSearchResponse(body: MovieListResponse): List<TopSearchDTO> {
        val newMovieList = mutableListOf<TopSearchDTO>()
        body.docs?.forEach { movie ->

            val stringBuilder = StringBuilder()
            movie.genres?.forEach {
                stringBuilder.append(it.name).append(" ")
            }

            newMovieList.add(
                TopSearchDTO(
                    title = movie.name ?: "Test",
                    genre = stringBuilder.toString(),
                    imageResId = R.drawable.movie,
                    imageUrl = movie.poster?.previewUrl
                )
            )
        }
        return newMovieList
    }

}

