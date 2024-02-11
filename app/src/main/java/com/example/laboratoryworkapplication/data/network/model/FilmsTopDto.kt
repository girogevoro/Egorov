package com.example.laboratoryworkapplication.data.network.model

import com.google.gson.annotations.SerializedName

data class FilmsTopDto(
    @SerializedName("pagesCount")
    val pagesCount: Int,
    @SerializedName("films")
    val films: List<FilmTopDto> = arrayListOf(),
)
