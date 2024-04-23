package com.example.funnyjokes.di

import com.example.funnyjokes.Const
import com.example.funnyjokes.data.network.ApiService
import com.example.funnyjokes.data.network.JokeRepositoryImpl
import com.example.funnyjokes.domain.JokeRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {
    @Provides
    @AppScope
    fun provideApiService(): ApiService{
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideJokeRepository(api: ApiService): JokeRepository{
        return JokeRepositoryImpl(api)
    }

}