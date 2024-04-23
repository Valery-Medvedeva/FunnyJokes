package com.example.funnyjokes.di

import com.example.funnyjokes.presentation.MainActivity
import dagger.Component

@AppScope
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}