package com.example.data.mapper.trending

import com.example.data.data_sources.local.entities.TrendingRepositoriesEntity
import com.example.data.data_sources.remote.dto.trending_repositories.TrendingGithubDataModel
import com.example.data.mapper.toTrendingRepositoriesEntity
import com.example.data.repository.trending.fakeTrendingGithubDataModel
import com.example.data.repository.trending.fakeTrendingGithubDataModel2
import com.example.data.repository.trending.fakeTrendingRepositoryEntity
import com.example.data.repository.trending.fakeTrendingRepositoryEntity2
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ToTrendingRepositoriesEntityMapperTest(
    private val inputData: TrendingGithubDataModel,
    private val expectedOutput: List<TrendingRepositoriesEntity>
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: DataModel = {0}, Expected = {1}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(
                    fakeTrendingGithubDataModel,
                    fakeTrendingRepositoryEntity
                ),
                arrayOf(
                    fakeTrendingGithubDataModel2,
                    fakeTrendingRepositoryEntity2
                )
            )
        }
    }
    @Test
    fun `toTrendingRepositoriesEntity(), when TrendingGithubDataModel then it should return TrendingRepositoriesEntity`() {
        // when
        val result = inputData.items.map { it.toTrendingRepositoriesEntity() }
        // then
        assertEquals(expectedOutput, result)
    }
}