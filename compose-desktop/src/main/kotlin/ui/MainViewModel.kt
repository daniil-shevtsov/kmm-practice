package ui

import com.example.kmmpractice.common.repository.HelloWorldRepository
import com.example.kmmpractice.common.presentation.MainViewState
import com.example.kmmpractice.common.presentation.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val helloWorldRepository: HelloWorldRepository
) : ViewModel {

    private lateinit var viewModelScope: CoroutineScope

    private val _state = MutableStateFlow(createInitialState())
    val state = _state.asStateFlow()

    override fun onInit() {
        val newMessage = helloWorldRepository.getHelloWorldMessage()

        viewModelScope.launch {
            _state.emit(_state.value.copy(message = newMessage))
        }
    }

    override fun setCoroutineScope(scope: CoroutineScope) {
        viewModelScope = scope
    }

    private fun createInitialState() = MainViewState(
        message = ""
    )

}