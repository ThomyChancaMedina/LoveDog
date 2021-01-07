package com.thomy.lovedog.data.server


import com.thomy.data.source.RemoteDataSource
import com.thomy.domain.Dog
import com.thomy.lovedog.data.toDomainDog

class DogDbDataSource: RemoteDataSource {

    override suspend fun getDogs(): List<Dog> =
        getDogsServer()
            .map { it.toDomainDog() }

}