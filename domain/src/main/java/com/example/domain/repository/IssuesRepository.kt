package com.example.domain.repository

import com.example.domain.model.IssuesDomainModel

interface IssuesRepository {
    suspend fun fetchIssues(owner: String, name: String): List<IssuesDomainModel>
}