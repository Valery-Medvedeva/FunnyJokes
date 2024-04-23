package com.example.funnyjokes.data.network

import com.example.funnyjokes.domain.Joke
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("random_joke")
    suspend fun getJoke(): Joke

}