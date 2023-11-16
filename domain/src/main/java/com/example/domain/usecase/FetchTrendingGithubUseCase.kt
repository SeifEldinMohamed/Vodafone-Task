package com.example.domain.usecase

import com.example.domain.model.TrendingGithubDomainModel
import com.example.domain.repository.TrendingRepository

class FetchTrendingGithubUseCase(
    private val trendingRepository: TrendingRepository
) {
    suspend operator fun invoke(isForceFetch: Boolean): List<TrendingGithubDomainModel> {
        return trendingRepository.fetchTrendingGithub(isForceFetch)
    }
}