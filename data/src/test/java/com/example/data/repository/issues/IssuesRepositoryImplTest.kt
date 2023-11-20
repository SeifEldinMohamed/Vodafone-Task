package com.example.data.repository.issues

import com.example.data.data_sources.remote.IssuesApi
import com.example.data.data_sources.remote.dto.issues.IssuesDataModel
import com.example.data.repository.IssuesRepositoryImpl
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class IssuesRepositoryImplTest {
    private lateinit var issuesRepositoryImp: IssuesRepositoryImpl
    private lateinit var issuesApi: IssuesApi

    @Before
    fun setup() {
        issuesApi = mockk()
        issuesRepositoryImp = IssuesRepositoryImpl(issuesApi)

    }

    /**
     * 1. fetching for issues
     * 2. return data fetched from api
     **/
    @Test
    fun `fetchTrendingRepository(), when isFirstTime = true and forceFetch = false, then return cache response of api in database then return pagingSource of trendingRepositoryDomainModel from database`() {
        runBlocking {
            // given
            val expected = fakeIssuesDomainModelList

            coEvery { issuesApi.fetchIssues(any(), any()) } returns Response.success(
                IssuesDataModel().apply {
                    addAll(fakeIssuesDataModelList)
                }
            )

            // when
           val result = issuesRepositoryImp.fetchIssues("Seif","Github")

            assertEquals(expected, result)

            // then
            coVerify { issuesApi.fetchIssues(any(), any()) }
        }
    }

    /**
     * 1. in case of error
     * 2. we throw exception
     **/
    @Test(expected = Exception::class)
    fun `fetchTrendingRepository() , when , then return trendingRepositoryDomainModel`() {
        runBlocking {
            // given
            coEvery { issuesApi.fetchIssues(any(), any()) } throws Exception()

            // when
            issuesRepositoryImp.fetchIssues("","")
        }
    }
}
