package com.example.presentation.screens.details

import app.cash.turbine.test
import com.example.domain.model.CustomExceptionDomainModel
import com.example.domain.usecase.FetchRepositoryDetailsUseCase
import com.example.presentation.model.CustomExceptionUiModel
import com.example.presentation.screens.details_screen.RepositoryDetailsViewModel
import com.example.presentation.screens.details_screen.ui_state.RepositoryDetailsUiState
import com.example.presentation.utils.MainCoroutineRule
import com.example.presentation.utils.TestDispatchersImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class DetailsViewModelTest {

    private lateinit var repositoryDetailsViewModel: RepositoryDetailsViewModel
    private lateinit var fetchRepositoryDetailsUseCase: FetchRepositoryDetailsUseCase
    private lateinit var testDispatcher: TestDispatchersImpl

    @get:Rule
    val mainDispatcherRule = MainCoroutineRule()

    @Before
    fun setup() {
        testDispatcher = TestDispatchersImpl()
        fetchRepositoryDetailsUseCase = mockk(relaxed = true)
        repositoryDetailsViewModel = RepositoryDetailsViewModel(fetchRepositoryDetailsUseCase, testDispatcher)
    }

    @Test
    fun `requestRepositoryDetails(), when successful call, then should emit DetailsUiState with loading then RepositoryDetailsUiModel`() {
        runTest {
            // Given
            coEvery { fetchRepositoryDetailsUseCase(any(), any()) } returns fakeDetailsDomainModel

            // When
            repositoryDetailsViewModel.requestRepositoryDetails("","")

            // Then
            repositoryDetailsViewModel.repoDetailsUiState.test {
                assertEquals(RepositoryDetailsUiState(isLoading = true), awaitItem())
                assertEquals(
                    RepositoryDetailsUiState(isLoading = false, repositoryDetails = fakeDetailsUiModel),
                    awaitItem()
                )
                cancelAndConsumeRemainingEvents()
            }
        }
    }

    @Test
    fun `requestRepositoryDetails(), when exception, then it should emit error state`() {
        runTest {
            // Given
            coEvery { fetchRepositoryDetailsUseCase(any(), any()) } throws CustomExceptionDomainModel.NetworkExceptionDomainModel

            // When
            backgroundScope.launch(UnconfinedTestDispatcher()) {
                repositoryDetailsViewModel.requestRepositoryDetails("","")

            }

            // Then
            repositoryDetailsViewModel.repoDetailsUiState.test {
                assertEquals(RepositoryDetailsUiState(isLoading = true), awaitItem())
                advanceUntilIdle()
                assertEquals(RepositoryDetailsUiState(
                    isLoading = false,
                    isError = true,
                    customErrorExceptionUiModel = CustomExceptionUiModel.Network
                ), awaitItem())
                cancelAndConsumeRemainingEvents()
            }
        }
    }
}