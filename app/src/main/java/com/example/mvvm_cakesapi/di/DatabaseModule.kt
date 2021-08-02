package com.example.mvvm_cakesapi.di

import android.app.Application
import androidx.room.Room
import com.example.mvvm_cakesapi.database.CakesDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    fun providersDatabase(application: Application):CakesDatabase{
        return Room.databaseBuilder(application, CakesDatabase::class.java, "cakes.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    single { providersDatabase(androidApplication()) }
}