package com.thomy.lovedog.di

import android.app.Application
import com.thomy.lovedog.ui.dogCard.CardActivityComponent
import com.thomy.lovedog.ui.dogCard.CardActivityModule
import com.thomy.lovedog.ui.main.MainFragmentComponent
import com.thomy.lovedog.ui.main.MainFragmentModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, DataModule::class])
interface DogsComponent {

    fun plus(module: MainFragmentModule): MainFragmentComponent
    fun plus(module: CardActivityModule): CardActivityComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): DogsComponent
    }

}