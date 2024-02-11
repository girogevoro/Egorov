package com.example.laboratoryworkapplication.ui.top_films

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.laboratoryworkapplication.domain.repository.FilmsTopRepository

class TopFilmsViewModel(private val filmsTopRepository: FilmsTopRepository) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = PAGE_SIZE)) {
        filmsTopRepository.getPagingSource()
    }.flow.cachedIn(viewModelScope)

    companion object {
        private const val PAGE_SIZE = 16
    }
}