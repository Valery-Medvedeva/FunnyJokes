package com.example.funnyjokes.data.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.funnyjokes.domain.Joke
import com.example.funnyjokes.domain.JokeLocalRepository
import javax.inject.Inject

class JokeLocalRepositoryImpl @Inject constructor(
    private val mapper: JokeMapper,
    private val jokeDao: JokeDao
) : JokeLocalRepository {
    override fun getJokeList(): LiveData<List<Joke>> {
       return jokeDao.getJokeListDb().map {
           mapper.mapListDbToListEntity(it)
       }
    }

    override suspend fun getJoke(jokeId: Int): Joke {
        return mapper.mapDbToEntity(jokeDao.getJokeDb(jokeId))
    }

    override suspend fun addJoke(joke: Joke) {
       jokeDao.addJokeDb(mapper.mapEntityToDb(joke))
    }

    override suspend fun deleteJoke(joke: Joke) {
      jokeDao.deleteJokeDb(mapper.mapEntityToDb(joke))
    }
}