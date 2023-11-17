package com.example.data.mapper

import com.example.data.data_sources.local.entities.TrendingRepositoriesEntity
import com.example.data.data_sources.remote.dto.TrendingGithubDataModel
import com.example.data.repository.fakeTrendingGithubDataModel
import com.example.data.repository.fakeTrendingGithubDataModel2
import com.example.data.repository.fakeTrendingRepositoryEntity
import com.example.data.repository.fakeTrendingRepositoryEntity2
import junit.framework.TestCase.assertEquals
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
        val result = inputData.toTrendingRepositoriesEntity()
        // then
        assertEquals(expectedOutput, result)
    }
}