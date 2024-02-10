package com.example.laboratoryworkapplication.data.network.model

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("filmId")
    val id: Int,
    @SerializedName("nameRu")
    val title: String,
    @SerializedName("year")
    val year: String,
    @SerializedName("genres")
    val genre: List<GenreDto> = arrayListOf(),
){
    data class GenreDto(
        @SerializedName("genre")
        val value: String,
    )
}