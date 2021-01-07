package com.thomy.lovedog.ui.dogCard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.thomy.domain.CardDogView
import com.thomy.domain.Dog
import com.thomy.lovedog.ui.common.ScopedViewModel
import com.thomy.usecases.FindDogByCountry
import kotlinx.coroutines.launch

class DogCardViewModel(
    private val country: String,
    private val findDogByCountry: FindDogByCountry
) : ScopedViewModel() {
    private var topCard: Dog? = null
    private var bottomCard: Dog? = null

    private var data: List<Dog> = listOf()

    private var currentIndex = 0
    private val stream = MutableLiveData<CardDogView>()

    val modelStream: LiveData<CardDogView>
        get() = stream


    private val _dog = MutableLiveData<UiModelCard>()
    val dog: LiveData<UiModelCard>
        get() {
            if (_dog.value == null) findDogsForCountry()
            return _dog
        }

    fun setDogs(dogs: List<Dog>) {
        data = dogs
    }


    sealed class UiModelCard {
        class GetAllDogs(val dogs: List<Dog>) : UiModelCard()

    }

    init {
        initScope()
        updateStream()
    }

    fun findDogsForCountry() = launch {
        _dog.value = UiModelCard.GetAllDogs(findDogByCountry.invoke(country))
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }

    fun swipe(): Boolean {
        return if (currentIndex < data.size) {
            currentIndex += 1
            updateStream()
            false
        } else {
            true
        }

    }

    private fun updateStream() {
        if (data.isNotEmpty()) {
            topCard = data[currentIndex % data.size]
            bottomCard = data[(currentIndex + 1) % data.size]

            stream.value = CardDogView(
                topCard!!,
                bottomCard!!,
            )
        }
    }

}