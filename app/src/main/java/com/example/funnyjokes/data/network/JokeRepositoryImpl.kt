package com.example.funnyjokes.data.network

import android.app.Application
import com.example.funnyjokes.domain.Joke
import com.example.funnyjokes.domain.JokeRepository
import javax.inject.Inject

class JokeRepositoryImpl @Inject constructor( private val apiService: ApiService):JokeRepository {
    override suspend fun getJoke(): Joke {
        return apiService.getJoke()
    }
}