package com.example.flickipics.data.repo

import android.content.Context
import com.example.flickipics.R
import com.example.flickipics.data.api.MovieService
import com.example.flickipics.data.response.MovieListResponse
import com.example.flickipics.di.IoDispatcher
import com.example.flickipics.ui.fragments.home.RecomendedDTO
import com.example.flickipics.ui.fragments.home.TopSearchDTO
import com.squareup.moshi.Moshi
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
    @ApplicationContext private val context: Context,
    private val moshi: Moshi
) : MovieRepository {

    override suspend fun fetchRecommendedMovieList(): List<RecomendedDTO> = withContext(io) {
        try {
            val json = context.assets.open("movielist.json")
                .bufferedReader()
                .use { it.readText() }
            val adapter = moshi.adapter(MovieListResponse::class.java)
            val res = adapter.fromJson(json) ?: MovieListResponse(emptyList())
            handleRecommendedResponse(res)

//            val resp = movieService.fetchMovieList()
//            if (resp.isSuccessful) {
//                val body = resp.body() ?: return@withContext emptyList()
//                handleResponse(body)
//            } else {
//                // log resp.errorBody() if needed
//                emptyList()
//            }
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
            val json = context.assets.open("top_search_movielist.json")
                .bufferedReader()
                .use { it.readText() }
            val adapter = moshi.adapter(MovieListResponse::class.java)
            val res = adapter.fromJson(json) ?: MovieListResponse(emptyList())
            handleTopSearchResponse(res)

//            val resp = movieService.fetchMovieList()
//            if (resp.isSuccessful) {
//                val body = resp.body() ?: return@withContext emptyList()
//                handleResponse(body)
//            } else {
//                // log resp.errorBody() if needed
//                emptyList()
//            }
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

    private fun handleRecommendedResponse(body: MovieListResponse): List<RecomendedDTO> {
        val newMovieList = mutableListOf<RecomendedDTO>()
        body.docs?.forEach { movie ->

            val stringBuilder = StringBuilder()
            movie.genres?.forEach {
                stringBuilder.append(it.name).append(" ")
            }

            newMovieList.add(
                RecomendedDTO(
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

