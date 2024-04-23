package com.example.funnyjokes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funnyjokes.domain.GetJokeUseCase
import com.example.funnyjokes.domain.Joke
import kotlinx.coroutines.launch
import javax.inject.Inject

class JokeViewModel @Inject constructor(
    private val getJokeUseCase: GetJokeUseCase
) : ViewModel() {

    private val _state = MutableLiveData<JokeState>()
    val state: LiveData<JokeState>
        get() = _state
    fun loadJoke() {
        _state.value = JokeState.Loading
        viewModelScope.launch {
            val joke = getJokeUseCase.invoke()
            _state.value = JokeState.Info(joke)
        }
    }

    fun showPunch(joke: Joke){
        _state.value=JokeState.Info(joke)
    }
}