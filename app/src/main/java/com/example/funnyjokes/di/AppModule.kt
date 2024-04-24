package com.example.funnyjokes.di

import android.app.Application
import androidx.room.Room
import com.example.funnyjokes.Const
import com.example.funnyjokes.data.database.JokeDao
import com.example.funnyjokes.data.database.JokeDatabase
import com.example.funnyjokes.data.network.ApiService
import com.example.funnyjokes.data.network.JokeRemoteRepositoryImpl
import com.example.funnyjokes.domain.JokeRemoteRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class AppModule {
    @Provides
    @AppScope
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @AppScope
    fun provideDatabase(application: Application): JokeDatabase {
        return Room.databaseBuilder(
            application,
            JokeDatabase::class.java,
            Const.JOKE_DB
        ).build()
    }

    @Provides
    fun provideJokeRepository(api: ApiService): JokeRemoteRepository {
        return JokeRemoteRepositoryImpl(api)
    }

    @AppScope
    @Provides
    fun provideJokeDao(jokeDatabase: JokeDatabase): JokeDao {
        return jokeDatabase.jokeDao()
    }
}