package com.example.domain.usecase

import com.example.domain.model.IssuesDomainModel
import com.example.domain.repository.IssuesRepository

class FetchIssuesUseCase(
    private val issuesRepository: IssuesRepository
) {
    suspend operator fun invoke(owner: String, name: String): List<IssuesDomainModel> {
        return issuesRepository.fetchIssues(owner, name)
    }
}