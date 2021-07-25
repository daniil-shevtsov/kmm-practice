package ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import di.koin

@Composable
fun MainScreen() {
    val viewModel = remember { MainViewModel(helloWorldRepository = koin.get()) }
    val viewState by viewModel.state.collectAsState()

    Text(text = viewState.message)
}