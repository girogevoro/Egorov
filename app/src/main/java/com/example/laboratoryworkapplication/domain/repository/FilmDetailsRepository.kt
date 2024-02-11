package com.example.laboratoryworkapplication.domain.repository

import com.example.laboratoryworkapplication.domain.LoadState
import com.example.laboratoryworkapplication.domain.entity.FilmDetails

interface FilmDetailsRepository {
    suspend fun getFilmDetailById(filmId: Int): LoadState<FilmDetails>
}