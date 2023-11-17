package com.example.presentation.screens.trending_screen

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.FetchTrendingGithubUseCase
import com.example.presentation.utils.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.example.presentation.mapper.toTrendingGithubUIModel
import com.example.presentation.screens.trending_screen.ui_state.TrendingUiState
import kotlinx.coroutines.launch

@HiltViewModel
class TrendingViewModel @Inject constructor(
    private val fetchTrendingGithubUseCase: FetchTrendingGithubUseCase,
    private val dispatcher: DispatcherProvider
) : ViewModel() {
    private val _trendingUiState = MutableStateFlow<TrendingUiState>(TrendingUiState(isLoading = true))
    val trendingUiState get() = _trendingUiState.asStateFlow()

    init {
        requestTrendingGithub(isForceFetch = false)
    }

    fun requestTrendingGithub(isForceFetch: Boolean) {
        _trendingUiState.value = TrendingUiState(isLoading = true)
        viewModelScope.launch(dispatcher.io) {
            try {
                fetchTrendingGithubUseCase(isForceFetch).let {
                    _trendingUiState.value = TrendingUiState(
                        isLoading = false,
                        trendingGithubList = it.map { trendingGithubDomainModel ->
                            trendingGithubDomainModel.toTrendingGithubUIModel()
                        }
                    )
                }
            } catch (e: Exception) {
                _trendingUiState.value = TrendingUiState(isLoading = false, isError = true)
            }
        }
    }
}