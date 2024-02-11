package com.example.laboratoryworkapplication.data.network.model

import com.google.gson.annotations.SerializedName

data class FilmTopDto(
    @SerializedName("filmId")
    val id: Int,
    @SerializedName("nameRu")
    val title: String?,
    @SerializedName("year")
    val year: String?,
    @SerializedName("posterUrlPreview")
    val posterUrlPreview: String?,
    @SerializedName("genres")
    val genres: List<GenreDto> = arrayListOf(),
)