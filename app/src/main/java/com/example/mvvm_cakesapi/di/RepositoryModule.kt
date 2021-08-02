package com.example.mvvm_cakesapi.di

import com.example.mvvm_cakesapi.database.CakesDatabase
import com.example.mvvm_cakesapi.network.CakeShop_APIServices
import com.example.mvvm_cakesapi.repository.CakesRepository
import org.koin.dsl.module

val repositoryModule = module {
    fun provideRepository(api:CakeShop_APIServices, dao: CakesDatabase): CakesRepository{
        return CakesRepository(api, dao)
    }

    single { provideRepository(get(), get()) }
}