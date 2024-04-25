package com.example.funnyjokes.presentation

import androidx.lifecycle.ViewModel
import com.example.funnyjokes.domain.GetJokeListFromDbUseCase
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
    private val getJokeListFromDbUseCase: GetJokeListFromDbUseCase
): ViewModel() {
    fun getJokeList(){
        val jokeList=getJokeListFromDbUseCase.invoke()
    }
}