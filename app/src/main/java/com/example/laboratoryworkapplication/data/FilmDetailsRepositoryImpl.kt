package com.example.laboratoryworkapplication.data

import com.example.laboratoryworkapplication.data.network.ApiService
import com.example.laboratoryworkapplication.domain.LoadState
import com.example.laboratoryworkapplication.domain.entity.FilmDetails
import com.example.laboratoryworkapplication.domain.repository.FilmDetailsRepository
import retrofit2.HttpException

class FilmDetailsRepositoryImpl(private val apiService: ApiService) : FilmDetailsRepository {
    override suspend fun getFilmDetailById(filmId: Int): LoadState<FilmDetails> {
        return try {
            val response = apiService.getFilmDetails(filmId)

            if (response.isSuccessful) {
                val filmDetails = response.body()!!.toFilmsDetails()
                LoadState.Success(filmDetails)
            } else {
                LoadState.Error(HttpException(response))
            }
        } catch (e: HttpException) {
            LoadState.Error(e)
        } catch (e: Exception) {
            LoadState.Error(e)
        }
    }
}