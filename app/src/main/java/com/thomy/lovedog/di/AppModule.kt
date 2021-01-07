package com.thomy.lovedog.di

import android.app.Application
import androidx.room.Room
import com.thomy.data.source.LocalDataSource
import com.thomy.data.source.RemoteDataSource
import com.thomy.lovedog.data.database.DogDatabase
import com.thomy.lovedog.data.database.RoomDataSource
import com.thomy.lovedog.data.server.DogDbDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        DogDatabase::class.java,
        "dog-db"

    ).build()

    @Provides
    fun localDataSourceProvide(db:DogDatabase): LocalDataSource = RoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(): RemoteDataSource = DogDbDataSource()
}