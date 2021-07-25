package ui

import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.example.kmmpractice.common.presentation.MainViewModel
import di.koin

@Composable
fun MainScreen() {
    val composableScope = rememberCoroutineScope()
    val viewModel = remember {
        MainViewModel(helloWorldRepository = koin.get()).apply {
            setCoroutineScope(composableScope)
            onInit()
        }
    }
    val viewState by viewModel.state.collectAsState()

    Text(text = viewState.message)
}