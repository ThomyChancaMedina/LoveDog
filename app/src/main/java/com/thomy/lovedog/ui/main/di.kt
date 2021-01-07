package com.thomy.lovedog.ui.main

import com.thomy.data.repository.DogsRepository
import com.thomy.usecases.GetDogs
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class MainFragmentModule {

    @Provides
    fun mainViewModelProvider(getDogs: GetDogs) = MainViewModel(getDogs)

    @Provides
    fun getDogsProvider(dogsRepository: DogsRepository) = GetDogs(dogsRepository)
}

@Subcomponent(modules = [(MainFragmentModule::class)])
interface MainFragmentComponent {
    val mainViewModel: MainViewModel
}