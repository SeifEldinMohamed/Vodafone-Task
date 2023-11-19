package com.example.domain.usecase

import androidx.paging.PagingData
import com.example.domain.model.TrendingGithubDomainModel
import com.example.domain.repository.TrendingRepository
import kotlinx.coroutines.flow.Flow

class FetchTrendingGithubUseCase(
    private val trendingRepository: TrendingRepository
) {
    operator fun invoke(isForceFetch: Boolean): Flow<PagingData<TrendingGithubDomainModel>> = trendingRepository.fetchTrendingGithub(isForceFetch)

}