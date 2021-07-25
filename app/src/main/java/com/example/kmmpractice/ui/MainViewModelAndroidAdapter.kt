package com.example.kmmpractice.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmmpractice.common.presentation.MainViewModel

class MainViewModelAndroidAdapter(
    val mainViewModel: MainViewModel
) : ViewModel() {

    init {
        mainViewModel.setCoroutineScope(viewModelScope)
        mainViewModel.onInit()
    }

    override fun onCleared() {
        mainViewModel.onDestroy()
    }

}