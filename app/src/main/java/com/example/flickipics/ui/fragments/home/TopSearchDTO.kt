package com.example.flickipics.ui.fragments.home

data class TopSearchDTO(
    val title: String,
    val genre: String,
    val imageResId: Int? = null,
    val imageUrl: String? = null,
)
