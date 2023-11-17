package com.example.presentation.screens.trending_screen.ui_state

import com.example.presentation.model.TrendingGithubUiModel

data class TrendingUiState(
    val trendingGithubList: List<TrendingGithubUiModel> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false
)