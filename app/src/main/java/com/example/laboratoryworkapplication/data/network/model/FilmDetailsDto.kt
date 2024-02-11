package com.example.laboratoryworkapplication.data.network.model

import com.google.gson.annotations.SerializedName

data class FilmDetailsDto(
    @SerializedName("kinopoiskId")
    val id: Int,
    @SerializedName("nameRu")
    val title: String,
    @SerializedName("posterUrl")
    val posterUrl: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("genres")
    val genres: List<GenreDto> = arrayListOf(),
    @SerializedName("countries")
    val countries: List<CountryDto> = arrayListOf(),
)

