package com.thomy.lovedog.data.database


import com.thomy.data.source.LocalDataSource
import com.thomy.lovedog.data.toDomainDog
import com.thomy.domain.Dog
import com.thomy.lovedog.data.toRoomDog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource(db: DogDatabase) : LocalDataSource {
    private val dogDao = db.DogDao()

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO) { dogDao.dogCount() <= 0 }


    override suspend fun saveDogs(dogs: List<Dog>) {
        withContext(Dispatchers.IO) { dogDao.insertDog(dogs.map { it.toRoomDog() }) }
    }

    override suspend fun getDogs(): List<Dog> =
        withContext(Dispatchers.IO) {
            dogDao.getAllDog().map { it.toDomainDog() }
        }

    override suspend fun findDogForCountry(country: String): List<Dog> = withContext(Dispatchers.IO){
        dogDao.findByCountry(country).map { it.toDomainDog() }
    }

    override suspend fun findById(id: Int): Dog = withContext(Dispatchers.IO){
        dogDao.findById(id).toDomainDog()
    }

    override suspend fun update(dog: Dog) {
        withContext(Dispatchers.IO){dogDao.updateDog(dog.toRoomDog())}
    }

}