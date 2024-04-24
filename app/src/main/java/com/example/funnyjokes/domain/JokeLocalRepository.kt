package com.example.funnyjokes.domain

import androidx.lifecycle.LiveData

interface JokeLocalRepository {

    fun getJokeList(): LiveData<List<Joke>>
    suspend fun getJoke(jokeId: Int): Joke
    suspend fun addJoke(joke: Joke)
    suspend fun deleteJoke(joke: Joke)
}