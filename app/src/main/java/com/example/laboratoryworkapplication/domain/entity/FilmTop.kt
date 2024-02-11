package com.example.laboratoryworkapplication.domain.entity

data class FilmTop(
    val id: Int,
    val title: String,
    val year: String,
    val posterUrlPreview: String,
    val genres: List<String> = arrayListOf(),
)
