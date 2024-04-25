package com.example.funnyjokes.domain

import javax.inject.Inject

class GetJokeFromDbUseCase @Inject constructor(
    private val repository: JokeLocalRepository
) {
    suspend operator fun invoke(jokeId:Int){
        repository.getJoke(jokeId)
    }
}