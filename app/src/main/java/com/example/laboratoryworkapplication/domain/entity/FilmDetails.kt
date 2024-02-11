package com.example.laboratoryworkapplication.domain.entity

import com.example.laboratoryworkapplication.data.network.model.CountryDto
import com.example.laboratoryworkapplication.data.network.model.GenreDto
import com.google.gson.annotations.SerializedName

data class FilmDetails(
    val id: Int,
    val title: String,
    val posterUrl: String,
    val description: String,
    val genres: List<String> = arrayListOf(),
    val countries: List<String> = arrayListOf(),
)