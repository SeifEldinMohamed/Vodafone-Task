package com.example.data.mapper.trending

import com.example.data.data_sources.local.entities.TrendingRepositoriesEntity
import com.example.data.mapper.toTrendingGithubDomainModel
import com.example.data.repository.trending.fakeTrendingGithubDomainModel
import com.example.data.repository.trending.fakeTrendingGithubDomainModel2
import com.example.data.repository.trending.fakeTrendingRepositoryEntity
import com.example.data.repository.trending.fakeTrendingRepositoryEntity2
import com.example.domain.model.TrendingGithubDomainModel
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class FromTrendingRepositoriesEntityToTrendingGithubDomainModelMapperTest(
    private val inputData: List<TrendingRepositoriesEntity>,
    private val expectedOutput: List<TrendingGithubDomainModel>
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: Entity = {0}, Domain = {1}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(
                    fakeTrendingRepositoryEntity,
                   fakeTrendingGithubDomainModel
                ),
                arrayOf(
                    fakeTrendingRepositoryEntity2,
                    fakeTrendingGithubDomainModel2
                )
            )
        }
    }
    @Test
    fun `toTrendingGithubDomainModel(), when TrendingEntity then it should return TrendingGithubDomainModel`() {
        // when
        val result = inputData.map { it.toTrendingGithubDomainModel() }
        // then
       assertEquals(expectedOutput, result)
    }
}