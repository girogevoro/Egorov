package com.example.laboratoryworkapplication.data

import androidx.paging.PagingSource
import com.example.laboratoryworkapplication.data.network.ApiService
import com.example.laboratoryworkapplication.data.network.FilmsTopPagingSource
import com.example.laboratoryworkapplication.domain.entity.FilmTop
import com.example.laboratoryworkapplication.domain.repository.FilmsTopRepository

class FilmsTopRepositoryImpl(private val apiService: ApiService) : FilmsTopRepository {
    override fun getPagingSource(): PagingSource<Int, FilmTop> {
        return FilmsTopPagingSource(apiService)
    }
}