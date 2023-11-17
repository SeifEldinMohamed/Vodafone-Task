package com.example.presentation.screens.trending_screen

import app.cash.turbine.test
import com.example.domain.usecase.FetchTrendingGithubUseCase
import com.example.presentation.screens.trending_screen.ui_state.TrendingUiState
import com.example.presentation.utils.MainCoroutineRule
import com.example.presentation.utils.TestDispatchersImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class TrendingViewModelTest {

    private lateinit var trendingViewModel: TrendingViewModel
    private lateinit var fetchTrendingGithubUseCase: FetchTrendingGithubUseCase
    private lateinit var testDispatcher: TestDispatchersImpl

    @get:Rule
    val mainDispatcherRule = MainCoroutineRule()

    @Before
    fun setup() {
        testDispatcher = TestDispatchersImpl()
        fetchTrendingGithubUseCase = mockk(relaxed = true)
        trendingViewModel = TrendingViewModel(fetchTrendingGithubUseCase, testDispatcher)
    }

    @Test
    fun `requestTrendingGithub(), when successful call, then should emit trendingUiState with loading then list of TrendingGithubUiModel`() {
        runTest {
            // Given
            coEvery { fetchTrendingGithubUseCase(any()) } returns fakeTrendingGithubListDomainModel

            // When
            trendingViewModel.requestTrendingGithub(false)

            // Then
            trendingViewModel.trendingUiState.test {
                assertEquals(TrendingUiState(isLoading = true), awaitItem())
                assertEquals(TrendingUiState(isLoading = false, trendingGithubList = fakeTrendingGithubListUiModel), awaitItem())
                cancelAndConsumeRemainingEvents()
            }
        }
    }

    @Test
    fun `requestNews with exception should emit error state`() {
        runTest {
            // Given
            coEvery { fetchTrendingGithubUseCase(any()) } throws Exception()

            // When
            trendingViewModel.requestTrendingGithub(false)

            // Then
            trendingViewModel.trendingUiState.test {
                assertEquals(TrendingUiState(isLoading = true), awaitItem())
                assertEquals(TrendingUiState(isLoading = false, isError = true), awaitItem())
                cancelAndConsumeRemainingEvents()

            }
        }
    }
}