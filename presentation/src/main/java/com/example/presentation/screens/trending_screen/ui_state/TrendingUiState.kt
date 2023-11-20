package com.example.presentation.screens.trending_screen.ui_state

import androidx.paging.PagingData
import com.example.presentation.model.CustomExceptionUiModel
import com.example.presentation.model.TrendingGithubUiModel
import kotlinx.coroutines.flow.Flow

data class TrendingUiState(
    val trendingGithubPagingDataFlow: Flow<PagingData<TrendingGithubUiModel>>? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val customErrorExceptionUiModel: CustomExceptionUiModel = CustomExceptionUiModel.Unknown
)