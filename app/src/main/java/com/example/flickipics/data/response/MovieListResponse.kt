package com.example.flickipics.data.response

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("docs") val docs: List<MovieResponse>? = null
)

data class MovieResponse(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("poster") val poster: MoviePosterResponse? = null,
    @SerializedName("genres") val genres: List<MovieGenresResponse>? = null
)

data class MoviePosterResponse(
    @SerializedName("url") val url: String? = null,
    @SerializedName("previewUrl") val previewUrl: String? = null
)

data class MovieGenresResponse(
    @SerializedName("name") val name: String? = null
)


