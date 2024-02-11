package com.example.laboratoryworkapplication.ui.details_film

import com.example.laboratoryworkapplication.domain.entity.FilmDetails

class DetailsFilmState {
    sealed interface LoadState {
        data class Success(val data: FilmDetails) : LoadState
        data class Error(val error: Throwable) : LoadState
        data object Loading : LoadState
    }
}