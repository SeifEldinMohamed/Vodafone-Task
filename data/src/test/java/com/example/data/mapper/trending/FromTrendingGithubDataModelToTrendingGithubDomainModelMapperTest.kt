package com.example.data.mapper.trending

import com.example.data.data_sources.remote.dto.trending_repositories.TrendingGithubDataModel
import com.example.data.mapper.toTrendingGithubDomainModel
import com.example.data.repository.trending.fakeTrendingGithubDataModel
import com.example.data.repository.trending.fakeTrendingGithubDataModel2
import com.example.data.repository.trending.fakeTrendingGithubDomainModel
import com.example.data.repository.trending.fakeTrendingGithubDomainModel2
import com.example.domain.model.TrendingGithubDomainModel
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class FromTrendingGithubDataModelToTrendingGithubDomainModelMapperTest(
    private val inputData: TrendingGithubDataModel,
    private val expectedOutput: List<TrendingGithubDomainModel>
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: DataModel = {0}, Expected = {1}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(
                    fakeTrendingGithubDataModel,
                   fakeTrendingGithubDomainModel
                ),
                arrayOf(
                    fakeTrendingGithubDataModel2,
                    fakeTrendingGithubDomainModel2
                )
            )
        }
    }
    @Test
    fun `toTrendingGithubDomainModel(), when TrendingGithubDataModel then it should return TrendingGithubDomainModel`() {
        // when
        val result = inputData.toTrendingGithubDomainModel()
        // then
        assertEquals(expectedOutput, result)
    }
}