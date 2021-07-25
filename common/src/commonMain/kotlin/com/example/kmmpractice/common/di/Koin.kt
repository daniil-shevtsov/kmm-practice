package com.example.kmmpractice.common.di

import com.example.kmmpractice.common.presentation.MainViewModel
import com.example.kmmpractice.common.repository.HelloWorldRepository
import com.example.kmmpractice.common.repository.HelloWorldRepositoryImpl
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(commonModule(), platformModule())
    }

fun commonModule() = module {
    single { provideHelloWorldRepository() }

    //TODO: Come up with some sane solution for viewmodel and its lifecycle
    single { provideMainViewModel(helloWorldRepository = get()) }
}

fun provideHelloWorldRepository(): HelloWorldRepository = HelloWorldRepositoryImpl()

fun provideMainViewModel(
    helloWorldRepository: HelloWorldRepository
) = MainViewModel(helloWorldRepository)