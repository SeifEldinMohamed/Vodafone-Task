package com.example.presentation.screens.trending_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.domain.model.CustomExceptionDomainModel
import com.example.domain.usecase.FetchTrendingGithubUseCase
import com.example.presentation.mapper.toCustomExceptionPresentationModel
import com.example.presentation.mapper.toTrendingGithubUIModel
import com.example.presentation.screens.trending_screen.ui_state.TrendingUiState
import com.example.presentation.utils.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingViewModel @Inject constructor(
    private val fetchTrendingGithubUseCase: FetchTrendingGithubUseCase,
    private val dispatcher: DispatcherProvider
) : ViewModel() {
    private val _trendingUiState =
        MutableStateFlow<TrendingUiState>(TrendingUiState(isLoading = true))
    val trendingUiState get() = _trendingUiState.asStateFlow()

    init {
        requestTrendingGithub(isForceFetch = false)
    }

    fun requestTrendingGithub(isForceFetch: Boolean) {
        _trendingUiState.value = TrendingUiState(isLoading = true)
        viewModelScope.launch(dispatcher.io) {
            try {
                fetchTrendingGithubUseCase(isForceFetch).catch {
                    _trendingUiState.value = TrendingUiState(
                        isLoading = false,
                        isError = true,
                        customErrorExceptionUiModel = (it as CustomExceptionDomainModel).toCustomExceptionPresentationModel()
                    )
                }
                    .cachedIn(viewModelScope)
                    .collect { pagingData ->
                        val mappedData = pagingData.map { trendingGithubDomainModel ->
                            trendingGithubDomainModel.toTrendingGithubUIModel()
                        }
                        _trendingUiState.value = TrendingUiState(
                            isLoading = false,
                            trendingGithubList = flowOf(mappedData)
                        )
                    }
            } catch (e: Exception) {
                _trendingUiState.value = TrendingUiState(
                    isLoading = false,
                    isError = true,
                    customErrorExceptionUiModel = (e as CustomExceptionDomainModel).toCustomExceptionPresentationModel()
                )
            }
        }
    }
}