package com.example.kmmpractice.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.getViewModel

@Composable
fun MainLayout() {
    val mainViewModel = getViewModel<MainViewModelAndroidAdapter>().mainViewModel
    val viewState by mainViewModel.state.collectAsState()

    Text(text = viewState.message)
}