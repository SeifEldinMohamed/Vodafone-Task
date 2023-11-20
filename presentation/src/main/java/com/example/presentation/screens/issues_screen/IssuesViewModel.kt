package com.example.presentation.screens.issues_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.CustomExceptionDomainModel
import com.example.domain.usecase.FetchIssuesUseCase
import com.example.presentation.mapper.toCustomExceptionPresentationModel
import com.example.presentation.mapper.toIssuesUiModel
import com.example.presentation.screens.issues_screen.ui_state.IssuesUiState
import com.example.presentation.utils.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IssuesViewModel @Inject constructor(
    private val fetchIssuesUseCase: FetchIssuesUseCase,
    private val dispatcher: DispatcherProvider
) : ViewModel() {
    private val _issuesUiState = MutableStateFlow<IssuesUiState>(IssuesUiState(isLoading = true))
    val issuesUiState get() = _issuesUiState.asStateFlow()

    fun requestIssues(owner: String, name: String) {
        _issuesUiState.value = IssuesUiState(isLoading = true)
        viewModelScope.launch(dispatcher.io) {
            try {
                fetchIssuesUseCase(owner, name).let { issuesList ->
                    _issuesUiState.value = IssuesUiState(
                        isLoading = false,
                        issuesList = issuesList.map { it.toIssuesUiModel() }

                    )
                }
            } catch (e: Exception) {
                _issuesUiState.value = IssuesUiState(
                    isLoading = false,
                    isError = true,
                    customErrorExceptionUiModel = (e as CustomExceptionDomainModel).toCustomExceptionPresentationModel()
                )
            }
        }
    }
}