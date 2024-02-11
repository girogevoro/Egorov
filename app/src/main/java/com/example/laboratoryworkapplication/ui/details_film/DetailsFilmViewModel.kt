package com.example.laboratoryworkapplication.ui.details_film

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratoryworkapplication.domain.LoadState
import com.example.laboratoryworkapplication.domain.repository.FilmDetailsRepository
import kotlinx.coroutines.launch

class DetailsFilmViewModel(private val filmDetailsRepository: FilmDetailsRepository) : ViewModel() {

    private val liveDataLoadState = MutableLiveData<DetailsFilmState.LoadState>()
    fun getLiveDataLoadState(): LiveData<DetailsFilmState.LoadState> = liveDataLoadState

    fun onLaunch(filmId: Int) {
        viewModelScope.launch {
            val filmDetailById = filmDetailsRepository.getFilmDetailById(filmId)
            liveDataLoadState.postValue(DetailsFilmState.LoadState.Loading)
            when (filmDetailById) {
                is LoadState.Success -> liveDataLoadState.postValue(
                    DetailsFilmState.LoadState.Success(
                        filmDetailById.data
                    )
                )

                is LoadState.Error -> liveDataLoadState.postValue(
                    DetailsFilmState.LoadState.Error(
                        filmDetailById.error
                    )
                )
            }
        }
    }
}