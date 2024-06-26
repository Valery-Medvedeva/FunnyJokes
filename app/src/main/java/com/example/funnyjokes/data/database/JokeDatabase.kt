package com.example.funnyjokes.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [JokeDb::class], version = 1, exportSchema = false)
abstract class JokeDatabase:RoomDatabase() {
    abstract fun jokeDao():JokeDao
}