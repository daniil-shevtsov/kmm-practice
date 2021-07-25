package com.example.kmmpractice.common.presentation

import kotlinx.coroutines.CoroutineScope

interface ViewModel {
    fun setCoroutineScope(scope: CoroutineScope)

    fun onInit() = Unit
    fun onDestroy() = Unit
}