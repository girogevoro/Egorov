package com.example.laboratoryworkapplication.di

import com.example.laboratoryworkapplication.ui.top_films.TopFilmsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val  topFilmsModule = module {
    viewModel { TopFilmsViewModel() }
}
