package com.example.kmmpractice.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmmpractice.common.repository.HelloWorldRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val helloWorldRepository: HelloWorldRepository
) : ViewModel() {

    private val _state = MutableStateFlow(createInitialState())
    val state = _state.asStateFlow()

    init {
        val newMessage = helloWorldRepository.getHelloWorldMessage()
        viewModelScope.launch {
            _state.emit(_state.value.copy(message = newMessage))
        }
    }

    private fun createInitialState() = MainViewState(
        message = ""
    )

}