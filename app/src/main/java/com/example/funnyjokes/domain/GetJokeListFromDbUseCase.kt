package com.example.funnyjokes.domain

import javax.inject.Inject

class GetJokeListFromDbUseCase @Inject constructor(
    private val repository: JokeLocalRepository
) {
    operator fun invoke() {
        repository.getJokeList()
    }
}