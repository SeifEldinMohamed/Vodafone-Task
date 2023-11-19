package com.example.data.repository

import com.example.data.data_sources.remote.RepoDetailsApi
import com.example.data.data_sources.remote.dto.repo_details.RepositoryDetailsDataModel
import com.example.data.mapper.toCustomExceptionDomainModel
import com.example.data.mapper.toRepositoryDetailsDomainModel
import com.example.domain.model.RepositoryDetailsDomainModel
import com.example.domain.repository.RepoDetailsRepository

class RepoDetailsRepositoryImp(
    private val repoDetailsApi: RepoDetailsApi
) : RepoDetailsRepository {
    override suspend fun fetchRepositoryDetails(
        owner: String,
        name: String
    ): RepositoryDetailsDomainModel {
        return try {
            val repoDetailsDataModel = repoDetailsApi.fetchRepoDetails(owner, name).body() as RepositoryDetailsDataModel
             repoDetailsDataModel.toRepositoryDetailsDomainModel()
        } catch (e:Exception){
            throw e.toCustomExceptionDomainModel()
        }
    }
}