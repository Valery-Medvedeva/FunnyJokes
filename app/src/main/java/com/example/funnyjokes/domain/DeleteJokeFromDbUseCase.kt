package com.example.funnyjokes.domain

import javax.inject.Inject

class DeleteJokeFromDbUseCase @Inject constructor(
    private val repository: JokeLocalRepository
) {
    suspend operator fun invoke(joke:Joke){
        repository.deleteJoke(joke)
    }
}