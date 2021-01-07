package com.thomy.usecases

import com.thomy.data.repository.DogsRepository
import com.thomy.domain.Dog

class GetDogs (private val dogsRepository: DogsRepository){
    suspend fun invoke():List<Dog> =  dogsRepository.getDogs()
}