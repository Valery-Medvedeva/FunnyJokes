package com.example.funnyjokes.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface JokeDao {
    @Query("SELECT * FROM jokes")
    fun getJokeListDb():LiveData<List<JokeDb>>
    @Query("SELECT * FROM jokes WHERE id=:jokeId")
    fun getJokeDb(jokeId: Int):JokeDb
    @Upsert
    suspend fun addJokeDb(joke: JokeDb)
    @Delete
    suspend fun deleteJokeDb(joke: JokeDb)
}