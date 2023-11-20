package com.example.data.data_sources.remote

import com.example.data.Constants.Companion.OWNER_KEY
import com.example.data.Constants.Companion.REPO_NAME_KEY
import com.example.data.data_sources.remote.dto.issues.IssuesDataModel
import com.example.data.data_sources.remote.dto.repo_details.RepositoryDetailsDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IssuesApi {
    @GET("repos/{$OWNER_KEY}/{$REPO_NAME_KEY}/issues")
    suspend fun fetchIssues(
        @Path(OWNER_KEY) owner: String,
        @Path(REPO_NAME_KEY) name: String
    ): Response<IssuesDataModel>
}