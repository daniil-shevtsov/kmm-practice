package ui

import com.example.kmmpractice.common.repository.HelloWorldRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val helloWorldRepository: HelloWorldRepository
) {

    private val _state = MutableStateFlow(createInitialState())
    val state = _state.asStateFlow()

    init {
        val newMessage = helloWorldRepository.getHelloWorldMessage()
        GlobalScope.launch {
            _state.emit(_state.value.copy(message = newMessage))
        }
    }

    private fun createInitialState() = MainViewState(
        message = ""
    )

}