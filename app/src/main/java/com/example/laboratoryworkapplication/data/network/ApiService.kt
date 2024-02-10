package com.example.laboratoryworkapplication.data.network

import com.example.laboratoryworkapplication.data.network.model.FilmsTopDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api/v2.2/films/top")
    fun getFilmsTop(
        @Query("page") page: Int,
        @Query("type") type:String = TOP_100_POPULAR_FILMS
    ): Deferred<FilmsTopDto>

    companion object{
        const val TOP_100_POPULAR_FILMS = "TOP_100_POPULAR_FILMS"
    }
}

