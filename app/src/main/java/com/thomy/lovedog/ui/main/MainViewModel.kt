package com.thomy.lovedog.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.thomy.domain.Dog
import com.thomy.lovedog.ui.common.Event
import com.thomy.lovedog.ui.common.ScopedViewModel
import com.thomy.usecases.GetDogs
import kotlinx.coroutines.launch

class MainViewModel(private val getDogs: GetDogs) : ScopedViewModel() {

    private val _dog = MutableLiveData<List<Dog>>()
    val dog: LiveData<List<Dog>>
        get() = _dog


    private val _model = MutableLiveData<Event<Unit>>()
    val model: LiveData<Event<Unit>>
        get() = _model

    init {
        initScope()
        refresh()
    }

    private fun refresh(){
        _model.value = Event(Unit)
    }

    fun getAllDogs(){
        launch {
            _dog.value= getDogs.invoke()
        }
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }

}