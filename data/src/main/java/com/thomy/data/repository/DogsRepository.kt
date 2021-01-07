package com.thomy.data.repository

import com.thomy.data.source.LocalDataSource
import com.thomy.data.source.RemoteDataSource
import com.thomy.domain.Dog


class DogsRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun getDogs(): List<Dog> {
        if (localDataSource.isEmpty()) {
            val dogs = remoteDataSource.getDogs()

            localDataSource.saveDogs(dogs)
        }
        return localDataSource.getDogs()
    }

    suspend fun findForCountry(country: String): List<Dog> =
        localDataSource.findDogForCountry(country)

    suspend fun update(dog: Dog) = localDataSource.update(dog)
}