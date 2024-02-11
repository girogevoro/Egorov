package com.example.laboratoryworkapplication.domain.repository

import androidx.paging.PagingSource
import com.example.laboratoryworkapplication.domain.entity.FilmTop

interface FilmsTopRepository {
    fun getPagingSource(): PagingSource<Int, FilmTop>
}