package com.example.funnyjokes.domain

interface JokeRemoteRepository {
    suspend fun getJoke(): Joke
}