package com.example.data.repository.trending

import app.cash.turbine.test
import com.example.data.data_sources.local.LocalDataSource
import com.example.data.data_sources.remote.TrendingGithubApi
import com.example.data.repository.TrendingRepositoryImp
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import java.lang.Exception

class TrendingRepositoryImpTest {
    private lateinit var trendingRepositoryImp: TrendingRepositoryImp
    private lateinit var trendingGithubApi: TrendingGithubApi
    private lateinit var localDataSource: LocalDataSource

    @Before
    fun setup() {
        trendingGithubApi = mockk()
        localDataSource = mockk()
        trendingRepositoryImp = TrendingRepositoryImp(trendingGithubApi, localDataSource)

    }

    /**
     * 1. fetching for first time ( isFirstTime = true ) and no force fetch (forceFetch = false)
     * 2. then fetch from api
     * 3. cache in database
     * 4. save that it's not first time to enter
     * 5. return cached data from database of type PagingData
     **/
    @Test
    fun `fetchTrendingRepository(), when isFirstTime = true and forceFetch = false, then return cache response of api in database then return pagingSource of trendingRepositoryDomainModel from database`() {
        runBlocking {
            // given
            val expected = fakeTrendingGithubPagingDataDomainModel

            coEvery { localDataSource.readIsFirstTime() } returns true
            coEvery { trendingGithubApi.fetchTrendingRepositories() } returns Response.success(
                fakeTrendingGithubDataModel
            )
            coEvery { localDataSource.insertTrendingRepositories(any()) } returns Unit
            coEvery { localDataSource.getTrendingRepositories() } returns FakeTrendingRepositoriesEntityPagingSource(
                fakeTrendingRepositoryEntity
            )

            coEvery { localDataSource.saveIsFirstTime(any()) } returns Unit

            // when
           val result = trendingRepositoryImp.fetchTrendingGithub(false)

            result.test {
                assertEquals(expected.javaClass, awaitItem().javaClass)
                cancelAndConsumeRemainingEvents()
            }

            // then
            coVerify { trendingGithubApi.fetchTrendingRepositories() }
            coVerify { localDataSource.insertTrendingRepositories(fakeTrendingRepositoryEntity) }
            coVerify { localDataSource.saveIsFirstTime(false) }
        }
    }

    /**
     * 1. not first time to enter app ( isFirstTime = false ) and we force fetch (forceFetch = true)
     * 2. then fetch from api
     * 3. cache in database
     * 4. save that it's not first time to enter
     * 5. return cached data from database of type PagingData
     **/
    @Test
    fun `fetchTrendingRepository(), when isFirstTime = false and forceFetch = true, then return trendingRepositoryDomainModel from api and cache data in database`() {
        runBlocking {
            // given
            val expected = fakeTrendingGithubPagingDataDomainModel
            coEvery { localDataSource.readIsFirstTime() } returns false
            coEvery { trendingGithubApi.fetchTrendingRepositories() } returns Response.success(
                fakeTrendingGithubDataModel
            )
            coEvery { localDataSource.insertTrendingRepositories(fakeTrendingRepositoryEntity) } returns Unit
            coEvery { localDataSource.getTrendingRepositories() } returns FakeTrendingRepositoriesEntityPagingSource(
                fakeTrendingRepositoryEntity
            )
            // when
            val result = trendingRepositoryImp.fetchTrendingGithub(true)

            // then
            result.test {
                assertEquals(expected.javaClass, awaitItem().javaClass)
                cancelAndConsumeRemainingEvents()
            }

            coVerify { trendingGithubApi.fetchTrendingRepositories() }
            coVerify { localDataSource.insertTrendingRepositories(fakeTrendingRepositoryEntity) }
            coVerify(exactly = 0) { localDataSource.saveIsFirstTime(any()) }
        }
    }

    /**
     * 1. not first time to enter app ( isFirstTime = false ) and no force fetch (forceFetch = false)
     * 2. return cached data from database of type PagingData
     **/
    @Test
    fun `fetchTrendingRepository(), when isFirstTime = false and forceFetch = false, then return trendingRepositoryDomainModel from database`() {
        runBlocking {
            // given
            val expected = fakeTrendingGithubPagingDataDomainModel
            coEvery { localDataSource.readIsFirstTime() } returns false
            coEvery { localDataSource.getTrendingRepositories() } returns FakeTrendingRepositoriesEntityPagingSource(
                fakeTrendingRepositoryEntity
            )

            // when
            val result = trendingRepositoryImp.fetchTrendingGithub(false)

            result.test {
                assertEquals(expected.javaClass, awaitItem().javaClass)
                cancelAndConsumeRemainingEvents()
            }
            // then
            coVerify { localDataSource.getTrendingRepositories() }
        }
    }
    /**
     * 1. in case of error
     * 2. we threw exception
     **/
    @Test(expected = Exception::class)
    fun `fetchTrendingRepository() , when , then return trendingRepositoryDomainModel`() {
        runBlocking {
            // given
            coEvery { trendingGithubApi.fetchTrendingRepositories() } throws Exception()

            // when
            trendingRepositoryImp.fetchTrendingGithub(false).collect()
        }
    }
}
