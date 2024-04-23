package com.example.funnyjokes.di

import androidx.lifecycle.ViewModel
import com.example.funnyjokes.presentation.JokeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @IntoMap
    @ViewModelKey(JokeViewModel::class)
    @Binds
    fun bindJokeViewModel(impl: JokeViewModel): ViewModel
}