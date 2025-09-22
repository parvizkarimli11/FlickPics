package com.example.flickipics.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieListResponse(
    @Json(name = "docs") val docs: List<MovieResponse>? = null
)

@JsonClass(generateAdapter = true)
data class MovieResponse(
    @Json(name = "id") val id: Int? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "poster") val poster: MoviePosterResponse? = null,
    @Json(name = "genres") val genres: List<MoviePosterResponse>? = null
)

@JsonClass(generateAdapter = true)
data class MoviePosterResponse(
    @Json(name = "url") val url: String? = null,
    @Json(name = "previewUrl") val previewUrl: String? = null
)

@JsonClass(generateAdapter = true)
data class MovieGenresResponse(
    @Json(name = "name") val name: String? = null
)


