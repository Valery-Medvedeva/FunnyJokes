package com.example.funnyjokes.data.database

import com.example.funnyjokes.domain.Joke
import javax.inject.Inject

class JokeMapper @Inject constructor() {
    fun mapEntityToDb(joke: Joke): JokeDb = JokeDb(
        id = joke.id,
        setup = joke.setup,
        punchline = joke.punchline
    )

    fun mapDbToEntity(jokeDb: JokeDb): Joke = Joke(
        id = jokeDb.id,
        setup = jokeDb.setup,
        punchline = jokeDb.punchline
    )

    fun mapListDbToListEntity(list: List<JokeDb>) = list.map {
        mapDbToEntity(it)
    }
}