package com.example.presentation.screens.issues

import app.cash.turbine.test
import com.example.domain.model.CustomExceptionDomainModel
import com.example.domain.usecase.FetchIssuesUseCase
import com.example.presentation.model.CustomExceptionUiModel
import com.example.presentation.screens.issues_screen.IssuesViewModel
import com.example.presentation.screens.issues_screen.ui_state.IssuesUiState
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
class IssuesViewModelTest {

    private lateinit var issuesViewModel: IssuesViewModel
    private lateinit var fetchIssuesUseCase: FetchIssuesUseCase
    private lateinit var testDispatcher: TestDispatchersImpl

    @get:Rule
    val mainDispatcherRule = MainCoroutineRule()

    @Before
    fun setup() {
        testDispatcher = TestDispatchersImpl()
        fetchIssuesUseCase = mockk(relaxed = true)
        issuesViewModel = IssuesViewModel(fetchIssuesUseCase, testDispatcher)
    }

    @Test
    fun `requestIssues(), when successful call, then should emit loading and then IssuesUiModel`() {
        runTest {
            // Given
            coEvery { fetchIssuesUseCase(any(), any()) } returns fakeIssuesDomainModelList

            // When
            issuesViewModel.requestIssues("","")

            // Then
            issuesViewModel.issuesUiState.test {
                assertEquals(IssuesUiState(isLoading = true), awaitItem())
                assertEquals(
                    IssuesUiState(isLoading = false, issuesList = fakeIssuesUiModelList),
                    awaitItem()
                )
                cancelAndConsumeRemainingEvents()
            }
        }
    }

    @Test
    fun `requestIssues(), when exception, then it should emit error state`() {
        runTest {
            // Given
            coEvery { fetchIssuesUseCase(any(), any()) } throws CustomExceptionDomainModel.NetworkExceptionDomainModel

            // When
            backgroundScope.launch(UnconfinedTestDispatcher()) {
                issuesViewModel.requestIssues("","")

            }

            // Then
            issuesViewModel.issuesUiState.test {
                assertEquals(IssuesUiState(isLoading = true), awaitItem())
                advanceUntilIdle()
                assertEquals(IssuesUiState(
                    isLoading = false,
                    isError = true,
                    customErrorExceptionUiModel = CustomExceptionUiModel.Network
                ), awaitItem())
                cancelAndConsumeRemainingEvents()
            }
        }
    }
}