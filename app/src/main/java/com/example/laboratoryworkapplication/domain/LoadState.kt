package com.example.laboratoryworkapplication.domain

sealed interface LoadState<out T> {
    data class Success<out T>(val data: T) : LoadState<T>
    data class Error(val error: Throwable) : LoadState<Nothing>
}

