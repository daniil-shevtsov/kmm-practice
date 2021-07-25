package com.example.kmmpractice.common.di

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
}

fun provideHelloWorldRepository(): HelloWorldRepository = HelloWorldRepositoryImpl()
