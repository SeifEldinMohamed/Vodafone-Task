package com.example.presentation.screens.issues_screen.ui_state

import com.example.presentation.model.CustomExceptionUiModel
import com.example.presentation.model.IssuesUiModel

data class IssuesUiState(
    val issuesList: List<IssuesUiModel>? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val customErrorExceptionUiModel: CustomExceptionUiModel = CustomExceptionUiModel.Unknown
)