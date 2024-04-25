package com.example.funnyjokes.di

import android.app.Application
import com.example.funnyjokes.presentation.FavoriteActivity
import com.example.funnyjokes.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: FavoriteActivity)

    @Component.Factory
    interface AppFactory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}