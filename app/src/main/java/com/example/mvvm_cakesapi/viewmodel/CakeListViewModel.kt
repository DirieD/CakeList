package com.example.mvvm_cakesapi.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvm_cakesapi.repository.CakesRepository
import kotlinx.coroutines.*
import java.lang.Exception

class CakeListViewModel(private val cakeRepository:CakesRepository): ViewModel() {
    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    val cakeListResults = cakeRepository.results

    init {
        refreshFromRepository()
    }

    fun refreshFromRepository(){
        viewModelScope.launch {
            try{
                cakeRepository.refreshCakes()

            }
            catch (networkError: Exception){

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}