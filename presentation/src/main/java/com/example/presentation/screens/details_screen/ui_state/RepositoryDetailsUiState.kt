package com.example.presentation.screens.details_screen.ui_state

import com.example.presentation.model.CustomExceptionUiModel
import com.example.presentation.model.RepositoryDetailsUiModel

data class RepositoryDetailsUiState(
    val repositoryDetails: RepositoryDetailsUiModel? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val customErrorExceptionUiModel: CustomExceptionUiModel = CustomExceptionUiModel.Unknown
)