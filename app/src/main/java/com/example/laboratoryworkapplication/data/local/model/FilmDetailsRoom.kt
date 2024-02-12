package com.example.laboratoryworkapplication.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FilmDetailsRoom(
    @PrimaryKey
    val id: Int,
    val title: String,
    val year: String?,
    @field:ColumnInfo(name = "poster_url")
    val posterUrl: String,
    val description: String,
    val genres: List<String> = arrayListOf(),
    val countries: List<String> = arrayListOf(),
)

