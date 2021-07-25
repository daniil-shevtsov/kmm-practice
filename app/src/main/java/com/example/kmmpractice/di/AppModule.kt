package com.example.kmmpractice.di

import com.example.kmmpractice.common.repository.HelloWorldRepository
import com.example.kmmpractice.common.repository.HelloWorldRepositoryImpl
import com.example.kmmpractice.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    viewModel {
        MainViewModel(
            helloWorldRepository = get()
        )
    }
}