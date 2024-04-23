package com.example.funnyjokes.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.funnyjokes.domain.GetJokeUseCase
import com.example.funnyjokes.domain.Joke
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

class JokeViewModel @Inject constructor(
    private val getJokeUseCase: GetJokeUseCase
) : ViewModel() {

    private val exceptionHandler= CoroutineExceptionHandler {
            _, throwable ->
        _state.value=JokeState.Error
        Log.d("JokeViewModel", throwable.toString())
    }

    private val coroutineScope= CoroutineScope(Dispatchers.Main+exceptionHandler)

    private val _state = MutableLiveData<JokeState>()
    val state: LiveData<JokeState>
        get() = _state
    fun loadJoke() {
        _state.value = JokeState.Loading
        coroutineScope.launch {
            val joke = getJokeUseCase.invoke()
            _state.value = JokeState.Info(joke)
        }
    }

    override fun onCleared() {
        super.onCleared()
        coroutineScope.cancel()
    }
}