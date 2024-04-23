package com.example.funnyjokes.presentation

import com.example.funnyjokes.domain.Joke

sealed class JokeState {
    data object Error: JokeState()
    data object Loading: JokeState()
    class Info (val joke: Joke): JokeState()
}