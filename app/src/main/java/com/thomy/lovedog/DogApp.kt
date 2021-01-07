package com.thomy.lovedog

import android.app.Application
import com.thomy.lovedog.di.DaggerDogsComponent
import com.thomy.lovedog.di.DogsComponent

class DogApp : Application() {
    lateinit var component: DogsComponent
        private set

    override fun onCreate() {
        super.onCreate()

        component = DaggerDogsComponent
            .factory()
            .create(this)
    }
}