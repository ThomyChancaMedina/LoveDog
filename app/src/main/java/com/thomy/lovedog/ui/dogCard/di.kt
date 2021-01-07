package com.thomy.lovedog.ui.dogCard

import com.thomy.data.repository.DogsRepository
import com.thomy.usecases.FindDogByCountry
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class CardActivityModule(private val country: String) {

    @Provides
    fun cardViewModelProvider(
        findDogByCountry: FindDogByCountry
    ): DogCardViewModel {
        return DogCardViewModel(country, findDogByCountry)
    }

    @Provides
    fun getDogProvider(repository: DogsRepository) = FindDogByCountry(repository)
}

@Subcomponent(modules = [(CardActivityModule::class)])
interface CardActivityComponent {
    val dogCardViewModel: DogCardViewModel
}