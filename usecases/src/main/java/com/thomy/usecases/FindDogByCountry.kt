package com.thomy.usecases

import com.thomy.data.repository.DogsRepository
import com.thomy.domain.Dog

class FindDogByCountry(private val dogsRepository: DogsRepository) {
    suspend fun invoke(country: String): List<Dog> = dogsRepository.findForCountry(country)
}