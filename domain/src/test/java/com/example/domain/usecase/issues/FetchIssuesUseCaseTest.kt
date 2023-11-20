package com.example.domain.usecase.issues

import com.example.domain.model.CustomExceptionDomainModel
import com.example.domain.repository.IssuesRepository
import com.example.domain.usecase.FetchIssuesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class FetchIssuesUseCaseTest {
    private lateinit var issuesRepository: IssuesRepository
    // CUT
    private lateinit var fetchIssuesUseCase: FetchIssuesUseCase

    @Before
    fun setup() {
        issuesRepository = mockk()
        fetchIssuesUseCase = FetchIssuesUseCase(issuesRepository)
    }
    /**
     * 1. invoke called
     * 2. in case of success, should return list of issues
     **/
    @Test
    fun `when invoke is called, then it should return a list of issuesDomainModel`() =
        runBlocking {
            // given
            coEvery { issuesRepository.fetchIssues(any(), any()) } returns fakeIssuesDomainModel

            // when
            val result = fetchIssuesUseCase("Seif", "Github")

            // then
            assertEquals(fakeIssuesDomainModel, result)
        }

    /**
     * 1. invoke called
     * 2. in case of Failure, should throw NetworkExceptionDomainModel
     **/
    @Test(expected = CustomExceptionDomainModel.NetworkExceptionDomainModel::class)
    fun `when repository throws an NetworkExceptionDomainModel, then invoke should throw the same exception`() {
        runBlocking {
            // given
            coEvery { issuesRepository.fetchIssues(any(), any()) } throws CustomExceptionDomainModel.NetworkExceptionDomainModel

            // when
            fetchIssuesUseCase("Seif", "Github")
        }
    }
}