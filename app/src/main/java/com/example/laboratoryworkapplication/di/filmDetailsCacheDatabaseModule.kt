package com.example.laboratoryworkapplication.di

import androidx.room.Room
import com.example.laboratoryworkapplication.data.local.FilmDetailsCacheDatabase
import org.koin.dsl.module

val filmDetailsCacheDatabaseModule = module {
    single<FilmDetailsCacheDatabase> {
        Room.databaseBuilder(
            context = get(),
            FilmDetailsCacheDatabase::class.java, "film_details_cache_database"
        ).build()
    }
}