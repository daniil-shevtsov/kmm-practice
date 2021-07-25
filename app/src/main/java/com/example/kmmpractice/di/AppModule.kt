package com.example.kmmpractice.di

import com.example.kmmpractice.common.repository.HelloWorldRepository
import com.example.kmmpractice.common.repository.HelloWorldRepositoryImpl
import com.example.kmmpractice.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun provideHelloWorldRepository(): HelloWorldRepository = HelloWorldRepositoryImpl()

val appModule = module {
    single { provideHelloWorldRepository() }
    
    viewModel {
        MainViewModel(
            helloWorldRepository = get()
        )
    }
}