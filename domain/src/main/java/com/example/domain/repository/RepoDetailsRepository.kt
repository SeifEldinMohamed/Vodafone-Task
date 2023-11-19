package com.example.domain.repository

import com.example.domain.model.RepositoryDetailsDomainModel

interface RepoDetailsRepository {
    suspend fun fetchRepositoryDetails(owner: String, name: String): RepositoryDetailsDomainModel
}