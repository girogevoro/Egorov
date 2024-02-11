package com.example.laboratoryworkapplication.domain.entity

data class FilmDetails(
    val id: Int,
    val title: String,
    val year: String,
    val posterUrl: String,
    val description: String,
    val genres: List<String> = arrayListOf(),
    val countries: List<String> = arrayListOf(),
)