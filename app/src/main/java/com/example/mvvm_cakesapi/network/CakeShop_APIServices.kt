package com.example.mvvm_cakesapi.network

import com.example.mvvm_cakesapi.database.DatabaseCakes
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface CakeShop_APIServices {
    @GET(API_Calls.API_CAKES_LIST)
    fun getCakeList ():Deferred<List<DatabaseCakes>>

}