package com.example.domain.usecase.trending

import com.example.domain.model.CustomExceptionDomainModel
import com.example.domain.repository.TrendingRepository
import com.example.domain.usecase.FetchTrendingGithubUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.test.assertFailsWith

class FetchTrendingGithubUseCaseTest {
    private lateinit var trendingRepository: TrendingRepository
    private lateinit var fetchTrendingGithubUseCase: FetchTrendingGithubUseCase

    @Before
    fun setup() {
        trendingRepository = mockk()
        fetchTrendingGithubUseCase = FetchTrendingGithubUseCase(trendingRepository)
    }

    @Test
    fun `when invoke is called, then it should return a list of TrendingGithubDomainModel`() =
        runBlocking {
            // given
            coEvery { trendingRepository.fetchTrendingGithub(any()) } returns fakeTrendingGithubLazyPagingDomainModel

            // when
            val result = fetchTrendingGithubUseCase(true)

            // then
            assertEquals(fakeTrendingGithubLazyPagingDomainModel, result)
        }


    @Test(expected = CustomExceptionDomainModel.NetworkExceptionDomainModel::class)
    fun `when repository throws an NetworkExceptionDomainModel, then invoke should throw the same exception`() {
        runBlocking {
            // given
            coEvery { trendingRepository.fetchTrendingGithub(any()) } throws CustomExceptionDomainModel.NetworkExceptionDomainModel

            // when
            fetchTrendingGithubUseCase(true)
        }
    }

    @Test(expected = CustomExceptionDomainModel.NoInternetConnectionExceptionDomainModel::class)
    fun `when repository throws an NoInternetConnectionExceptionDomainModel, then invoke should throw the same exception`() {
        runBlocking {
            // given
            coEvery { trendingRepository.fetchTrendingGithub(any()) } throws CustomExceptionDomainModel.NoInternetConnectionExceptionDomainModel

            // when
            fetchTrendingGithubUseCase(true)
        }
    }

    @Test(expected = CustomExceptionDomainModel.TimeoutExceptionDomainModel::class)
    fun `when repository throws an TimeoutExceptionDomainModel, then invoke should throw the same exception`() {
        runBlocking {
            // given
            coEvery { trendingRepository.fetchTrendingGithub(any()) } throws CustomExceptionDomainModel.TimeoutExceptionDomainModel

            // when
            fetchTrendingGithubUseCase(true)
        }
    }

    @Test(expected = CustomExceptionDomainModel.ServiceNotFoundExceptionDomainModel::class)
    fun `when repository throws an ServiceNotFoundExceptionDomainModel, then invoke should throw the same exception`() {
        runBlocking {
            // given
            coEvery { trendingRepository.fetchTrendingGithub(any()) } throws CustomExceptionDomainModel.ServiceNotFoundExceptionDomainModel

            // when
            fetchTrendingGithubUseCase(true)
        }
    }

    @Test(expected = CustomExceptionDomainModel.AccessDeniedExceptionDomainModel::class)
    fun `when repository throws an AccessDeniedExceptionDomainModel, then invoke should throw the same exception`() {
        runBlocking {
            // given
            coEvery { trendingRepository.fetchTrendingGithub(any()) } throws CustomExceptionDomainModel.AccessDeniedExceptionDomainModel

            // when
            fetchTrendingGithubUseCase(true)
        }
    }

    @Test(expected = CustomExceptionDomainModel.ServiceUnavailableExceptionDomainModel::class)
    fun `when repository throws an ServiceUnavailableExceptionDomainModel, then invoke should throw the same exception`() {
        runBlocking {
            // given
            coEvery { trendingRepository.fetchTrendingGithub(any()) } throws CustomExceptionDomainModel.ServiceUnavailableExceptionDomainModel

            // when
            fetchTrendingGithubUseCase(true)
        }
    }

    @Test
    fun `when repository throws an UnknownExceptionDomainModel, then invoke should throw the same exception`() {
        runBlocking {
            // given
            coEvery { trendingRepository.fetchTrendingGithub(any()) } throws CustomExceptionDomainModel.UnknownExceptionDomainModel

            // when
            assertFailsWith<CustomExceptionDomainModel.UnknownExceptionDomainModel> {
                fetchTrendingGithubUseCase(true)
            }
        }
    }
}