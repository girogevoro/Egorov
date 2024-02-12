package com.example.laboratoryworkapplication.data

import com.example.laboratoryworkapplication.data.local.FilmDetailsCacheDatabase
import com.example.laboratoryworkapplication.data.network.ApiService
import com.example.laboratoryworkapplication.domain.LoadState
import com.example.laboratoryworkapplication.domain.entity.FilmDetails
import com.example.laboratoryworkapplication.domain.repository.FilmDetailsRepository
import retrofit2.HttpException

class FilmDetailsRepositoryImpl(
    private val apiService: ApiService,
    private val filmDetailsCacheDatabase: FilmDetailsCacheDatabase,
) : FilmDetailsRepository {
    override suspend fun getFilmDetailById(filmId: Int): LoadState<FilmDetails> {
        val dao = filmDetailsCacheDatabase.dao()
        val filmDetailsRoom = dao.getById(filmId)

        return if (filmDetailsRoom == null) {
            val request = request(filmId)
            if (request is LoadState.Success<FilmDetails>) {
                dao.insert(request.data.toFilmDetailsRoom())
            }
            request
        } else {
            LoadState.Success(filmDetailsRoom.toFilmDetails())
        }
    }

    private suspend fun request(filmId: Int) = try {
        val response = apiService.getFilmDetails(filmId)

        if (response.isSuccessful) {
            val filmDetails = response.body()!!.toFilmDetails()
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