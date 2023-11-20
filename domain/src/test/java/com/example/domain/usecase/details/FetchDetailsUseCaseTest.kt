package com.example.domain.usecase.details

import com.example.domain.model.CustomExceptionDomainModel
import com.example.domain.repository.RepoDetailsRepository
import com.example.domain.usecase.FetchRepositoryDetailsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FetchDetailsUseCaseTest {
    private lateinit var repoDetailsRepository: RepoDetailsRepository
    // CUT
    private lateinit var fetchRepositoryDetailsUseCase: FetchRepositoryDetailsUseCase

    @Before
    fun setup() {
        repoDetailsRepository = mockk()
        fetchRepositoryDetailsUseCase = FetchRepositoryDetailsUseCase(repoDetailsRepository)
    }
    /**
     * 1. invoke called
     * 2. in case of success, should return repositoryDetailsDomainModel
     **/
    @Test
    fun `when invoke is called, then it should return repositoryDetailsDomainModel`() =
        runBlocking {
            // given
            coEvery { repoDetailsRepository.fetchRepositoryDetails(any(), any()) } returns fakeDetailsDomainModel

            // when
            val result = fetchRepositoryDetailsUseCase("Seif", "Github")

            // then
            assertEquals(fakeDetailsDomainModel, result)
        }

    /**
     * 1. invoke called
     * 2. in case of Failure, should throw NetworkExceptionDomainModel
     **/
    @Test(expected = CustomExceptionDomainModel.NetworkExceptionDomainModel::class)
    fun `when repository throws an NetworkExceptionDomainModel, then invoke should throw the same exception`() {
        runBlocking {
            // given
            coEvery { repoDetailsRepository.fetchRepositoryDetails(any(), any()) } throws CustomExceptionDomainModel.NetworkExceptionDomainModel

            // when
            fetchRepositoryDetailsUseCase("Seif", "Github")
        }
    }
}