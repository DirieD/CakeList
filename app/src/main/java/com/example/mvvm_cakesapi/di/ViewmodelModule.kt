package com.example.mvvm_cakesapi.di

import com.example.mvvm_cakesapi.viewmodel.CakeListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CakeListViewModel(get()) }
}