package com.example.laboratoryworkapplication

import android.app.Application
import com.example.laboratoryworkapplication.di.apiServiceModule
import com.example.laboratoryworkapplication.di.detailsFilmModule
import com.example.laboratoryworkapplication.di.filmDetailsCacheDatabaseModule
import com.example.laboratoryworkapplication.di.topFilmsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                topFilmsModule, apiServiceModule, detailsFilmModule, filmDetailsCacheDatabaseModule
            )
        }
    }
}
