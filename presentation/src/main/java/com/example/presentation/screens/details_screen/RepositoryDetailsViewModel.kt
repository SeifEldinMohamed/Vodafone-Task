package com.example.presentation.screens.details_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.CustomExceptionDomainModel
import com.example.domain.usecase.FetchRepositoryDetailsUseCase
import com.example.presentation.mapper.toCustomExceptionPresentationModel
import com.example.presentation.mapper.toRepositoryDetailsUIModel
import com.example.presentation.screens.details_screen.ui_state.RepositoryDetailsUiState
import com.example.presentation.utils.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoryDetailsViewModel @Inject constructor(
    private val fetchRepositoryDetailsUseCase: FetchRepositoryDetailsUseCase,
    private val dispatcher: DispatcherProvider
) : ViewModel() {
    private val _repoDetailsUiState = MutableStateFlow<RepositoryDetailsUiState>(RepositoryDetailsUiState(isLoading = true))
    val repoDetailsUiState get() = _repoDetailsUiState.asStateFlow()

    fun requestRepositoryDetails(owner: String, name:String) {
        _repoDetailsUiState.value = RepositoryDetailsUiState(isLoading = true)
        viewModelScope.launch(dispatcher.io) {
            try {
                fetchRepositoryDetailsUseCase(owner, name).let {
                    _repoDetailsUiState.value = RepositoryDetailsUiState(
                        isLoading = false,
                        repositoryDetails = it.toRepositoryDetailsUIModel()

                    )
                }
            } catch (e: Exception) {
                _repoDetailsUiState.value = RepositoryDetailsUiState(
                    isLoading = false,
                    isError = true,
                    customErrorExceptionUiModel = (e as CustomExceptionDomainModel).toCustomExceptionPresentationModel()
                )
            }
        }
    }
}