package com.example.flickipics.ui.fragments.home

data class RecommendedDTO(
    var title: String,
    var imageResId: Int? = null,
    var genre: String? = null,
    var imageUrl: String? = null
)
