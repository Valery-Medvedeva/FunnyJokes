package com.example.funnyjokes.di

import androidx.lifecycle.ViewModel
import com.example.funnyjokes.presentation.FavoriteViewModel
import com.example.funnyjokes.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindMainViewModel(impl: MainViewModel): ViewModel

    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    @Binds
    fun bindFavoriteViewModel(impl: FavoriteViewModel): ViewModel
}