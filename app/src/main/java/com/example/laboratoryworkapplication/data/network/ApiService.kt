package com.example.laboratoryworkapplication.data.network

import com.example.laboratoryworkapplication.data.network.model.FilmDetailsDto
import com.example.laboratoryworkapplication.data.network.model.FilmsTopDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/api/v2.2/films/top")
    suspend fun getFilmsTop(
        @Query("page") page: Int,
        @Query("type") type: String = TOP_100_POPULAR_FILMS
    ): Response<FilmsTopDto>

    @GET("/api/v2.2/films/{movie_id}")
    suspend fun getFilmDetails(@Path("movie_id") movieId: Int):Response<FilmDetailsDto>


    companion object {
        const val TOP_100_POPULAR_FILMS = "TOP_100_POPULAR_FILMS"
    }
}
