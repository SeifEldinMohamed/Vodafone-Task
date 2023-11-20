package com.example.data.repository.details

import com.example.data.data_sources.remote.RepoDetailsApi
import com.example.data.repository.RepoDetailsRepositoryImp
import com.example.domain.model.CustomExceptionDomainModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.io.InterruptedIOException
import java.net.HttpURLConnection

class RepoDetailsRepositoryImplTest {
    private lateinit var repoDetailsRepositoryImp: RepoDetailsRepositoryImp
    private lateinit var detailsApi: RepoDetailsApi

    @Before
    fun setup() {
        detailsApi = mockk()
        repoDetailsRepositoryImp = RepoDetailsRepositoryImp(detailsApi)

    }

    /**
     * 1. fetching repo details
     * 2. return data fetched from api
     **/
    @Test
    fun `fetchRepoDetails(), when success call, then it should return DetailsDomainModel`() {
        runBlocking {
            // given
            val expected = fakeDetailsDomainModel

            coEvery { detailsApi.fetchRepoDetails(any(), any()) } returns Response.success(fakeDetailsDataModel)

            // when
           val result = repoDetailsRepositoryImp.fetchRepositoryDetails("Seif","Github")

            assertEquals(expected, result)

            // then
            coVerify { detailsApi.fetchRepoDetails(any(), any()) }
        }
    }

    /**
     * 1. in case of error
     * 2. we throw exception
     **/
    @Test(expected = CustomExceptionDomainModel.TimeoutExceptionDomainModel::class)
    fun `fetchRepoDetails() , when failure,  then throw TimeoutExceptionDomainModel`() {
        runBlocking {
            // given
            coEvery { detailsApi.fetchRepoDetails(any(), any()) } throws InterruptedIOException()

            // when
            repoDetailsRepositoryImp.fetchRepositoryDetails("","")
        }
    }

    @Test(expected = CustomExceptionDomainModel.NetworkExceptionDomainModel::class)
    fun `fetchRepoDetails() , when failure,  then throw NetworkExceptionDomainModel`() {
        runBlocking {
            // given
            coEvery { detailsApi.fetchRepoDetails(any(), any()) } throws IOException()

            // when
            repoDetailsRepositoryImp.fetchRepositoryDetails("","")
        }
    }

    @Test(expected = CustomExceptionDomainModel.ServiceNotFoundExceptionDomainModel::class)
    fun `fetchRepoDetails() , when failure,  then throw ServiceUnavailableExceptionDomainModel`() {
        runBlocking {
            // given
            coEvery { detailsApi.fetchRepoDetails(any(), any()) } throws  HttpException(Response.error<Any>(
                HttpURLConnection.HTTP_NOT_FOUND, "".toResponseBody())
            )

            // when
            repoDetailsRepositoryImp.fetchRepositoryDetails("","")
        }
    }

    @Test(expected = CustomExceptionDomainModel.UnknownExceptionDomainModel::class)
    fun `fetchRepoDetails() , when failure,  then throw UnknownExceptionDomainModel`() {
        runBlocking {
            // given
            coEvery { detailsApi.fetchRepoDetails(any(), any()) } throws  Exception()

            // when
            repoDetailsRepositoryImp.fetchRepositoryDetails("","")
        }
    }
}
