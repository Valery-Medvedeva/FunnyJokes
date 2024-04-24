package com.example.funnyjokes.data.network

import com.example.funnyjokes.domain.Joke
import com.example.funnyjokes.domain.JokeRemoteRepository
import javax.inject.Inject

class JokeRemoteRepositoryImpl @Inject constructor(private val apiService: ApiService):JokeRemoteRepository {
    override suspend fun getJoke(): Joke {
        return apiService.getJoke()
    }
}