package com.example.data.repository

import com.example.data.data_sources.remote.IssuesApi
import com.example.data.data_sources.remote.dto.issues.IssuesDataModel
import com.example.data.mapper.toCustomExceptionDomainModel
import com.example.data.mapper.toIssuesDomainModel
import com.example.domain.model.IssuesDomainModel
import com.example.domain.repository.IssuesRepository

class IssuesRepositoryImpl(
    private val issuesApi: IssuesApi
) : IssuesRepository {
    override suspend fun fetchIssues(
        owner: String,
        name: String
    ): List<IssuesDomainModel> {
        return try {
            val issuesDataModel = issuesApi.fetchIssues(owner, name).body() as IssuesDataModel
            issuesDataModel.map { it.toIssuesDomainModel() }
        } catch (e:Exception){
            throw e.toCustomExceptionDomainModel()
        }
    }
}