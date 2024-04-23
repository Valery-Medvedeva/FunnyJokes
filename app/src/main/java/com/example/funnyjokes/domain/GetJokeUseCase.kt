package com.example.funnyjokes.domain

import javax.inject.Inject

class GetJokeUseCase @Inject constructor (private val repository: JokeRepository) {
    suspend operator fun invoke(): Joke{
        return repository.getJoke()
    }
}