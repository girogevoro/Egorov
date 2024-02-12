package com.example.laboratoryworkapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.laboratoryworkapplication.data.local.model.FilmDetailsRoom

@Database(entities = [FilmDetailsRoom::class], version = 1, exportSchema = true)
@TypeConverters(Converters::class)
abstract class FilmDetailsCacheDatabase : RoomDatabase() {
    abstract fun dao(): FilmDetailsCacheDao
}
