package com.example.laboratoryworkapplication.data

import com.example.laboratoryworkapplication.data.network.model.FilmDetailsDto
import com.example.laboratoryworkapplication.data.network.model.FilmTopDto
import com.example.laboratoryworkapplication.domain.entity.FilmDetails
import com.example.laboratoryworkapplication.domain.entity.FilmTop

internal fun FilmTopDto.toFilmTop(): FilmTop {
    return FilmTop(id = id,
        title = title ?: "",
        year = year ?: "",
        posterUrlPreview = posterUrlPreview ?: "",
        genres = genres.map { it.value ?: "" }
    )
}

internal fun FilmDetailsDto.toFilmsDetails(): FilmDetails {
    return FilmDetails(
        id = id,
        title = title,
        posterUrl = posterUrl,
        description = description,
        genres = genres.map { it.value ?: "" },
        countries = countries.map { it.value ?: "" }
    )
}