package com.example.domain.usecase

import com.example.domain.repository.TrendingRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

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
            coEvery { trendingRepository.fetchTrendingGithub(any()) } returns fakeTrendingGithubListDomainModel

            // when
            val result = fetchTrendingGithubUseCase(true)

            // then
            assertEquals(fakeTrendingGithubListDomainModel, result)
        }


    @Test(expected = Exception::class)
    fun `when repository throws an Exception, then invoke should throw the same exception`() {
        runBlocking {
            // given
            coEvery { trendingRepository.fetchTrendingGithub(any()) } throws Exception()

            // when
            fetchTrendingGithubUseCase(true)
        }
    }
}