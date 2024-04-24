package com.example.funnyjokes

import android.app.Application
import com.example.funnyjokes.di.DaggerAppComponent

class JavaApplication : Application() {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }
}