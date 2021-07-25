package com.example.kmmpractice.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.koin.androidx.compose.getViewModel

@Composable
fun MainLayout() {
    val mainViewModel = getViewModel<MainViewModel>()
    val viewState by mainViewModel.state.collectAsState()

    Text(text = viewState.message)
}