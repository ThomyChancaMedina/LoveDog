package com.thomy.lovedog.di

import com.thomy.data.repository.DogsRepository
import com.thomy.data.source.LocalDataSource
import com.thomy.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun dogRepositoryProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    )= DogsRepository(localDataSource,remoteDataSource)
}