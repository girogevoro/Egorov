package com.example.laboratoryworkapplication.di

import com.example.laboratoryworkapplication.data.FilmDetailsRepositoryImpl
import com.example.laboratoryworkapplication.domain.repository.FilmDetailsRepository
import com.example.laboratoryworkapplication.ui.details_film.DetailsFilmViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailsFilmModule = module {
    viewModel { DetailsFilmViewModel(filmDetailsRepository = get()) }
    single<FilmDetailsRepository> { FilmDetailsRepositoryImpl(apiService = get()) }
}
