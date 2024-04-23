package com.example.funnyjokes.domain

interface JokeRepository {
    suspend fun getJoke(): Joke
}