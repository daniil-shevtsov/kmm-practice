package com.example.kmmpractice.ui

import androidx.lifecycle.ViewModel as OgAndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmmpractice.common.presentation.MainViewState
import com.example.kmmpractice.common.presentation.ViewModel
import com.example.kmmpractice.common.repository.HelloWorldRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val helloWorldRepository: HelloWorldRepository
) : OgAndroidViewModel(), ViewModel {

    private val _state = MutableStateFlow(createInitialState())
    val state = _state.asStateFlow()

    init {
        onInit()
    }

    override fun setCoroutineScope(scope: CoroutineScope) {

    }

    override fun onInit() {
        val newMessage = helloWorldRepository.getHelloWorldMessage()
        viewModelScope.launch {
            _state.emit(_state.value.copy(message = newMessage))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun createInitialState() = MainViewState(
        message = ""
    )

}