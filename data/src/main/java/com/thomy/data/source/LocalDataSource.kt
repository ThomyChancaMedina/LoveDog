package com.thomy.data.source

import com.thomy.domain.Dog


interface LocalDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun saveDogs(dogs: List<Dog>)
    suspend fun getDogs(): List<Dog>
    suspend fun findDogForCountry(country:String):List<Dog>
    suspend fun findById(id: Int): Dog
    suspend fun update(dog: Dog)
}