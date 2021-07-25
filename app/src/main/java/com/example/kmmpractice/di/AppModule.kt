package com.example.kmmpractice.di

import com.example.kmmpractice.ui.MainViewModelAndroidAdapter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    viewModel {
        MainViewModelAndroidAdapter(
            mainViewModel = get()
        )
    }
}