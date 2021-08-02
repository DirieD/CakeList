package com.example.mvvm_cakesapi.repository

import androidx.lifecycle.LiveData
import com.example.mvvm_cakesapi.database.CakesDatabase
import com.example.mvvm_cakesapi.database.DatabaseCakes
import com.example.mvvm_cakesapi.network.CakeShop_APIServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CakesRepository(private val cakeshopApiservices: CakeShop_APIServices, private val database: CakesDatabase) {
    suspend fun refreshCakes(){
        withContext(Dispatchers.IO){
            val cakeList = cakeshopApiservices.getCakeList().await()
            database.cakesDao.insertAll(cakeList)
        }
    }

    val results : LiveData<List<DatabaseCakes>> = database.cakesDao.getLocalDBCakes()
}