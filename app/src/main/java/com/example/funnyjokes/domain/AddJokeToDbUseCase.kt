package com.example.funnyjokes.domain

import javax.inject.Inject

class AddJokeToDbUseCase @Inject constructor(
    private val repository: JokeLocalRepository
) {
    suspend operator fun invoke(joke: Joke){
        repository.addJoke(joke)
    }
}