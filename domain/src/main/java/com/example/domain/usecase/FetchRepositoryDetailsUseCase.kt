package com.example.domain.usecase

import com.example.domain.model.RepositoryDetailsDomainModel
import com.example.domain.repository.RepoDetailsRepository

class FetchRepositoryDetailsUseCase(
    private val repoDetailsRepository: RepoDetailsRepository
) {
    suspend operator fun invoke(owner: String, name: String): RepositoryDetailsDomainModel {
        return repoDetailsRepository.fetchRepositoryDetails(owner, name)
    }
}