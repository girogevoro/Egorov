package com.example.laboratoryworkapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.laboratoryworkapplication.data.local.model.FilmDetailsRoom

@Dao
interface FilmDetailsCacheDao {
    @Insert
    suspend fun insert(vararg filmDetails: FilmDetailsRoom)

    @Query("SELECT * FROM FilmDetailsRoom WHERE id LIKE :filmId LIMIT 1")
    suspend fun getById(filmId: Int): FilmDetailsRoom?
}