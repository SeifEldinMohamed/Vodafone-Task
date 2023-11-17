package com.example.data.mapper

import com.example.data.data_sources.local.entities.TrendingRepositoriesEntity
import com.example.data.repository.fakeTrendingGithubDomainModel
import com.example.data.repository.fakeTrendingGithubDomainModel2
import com.example.data.repository.fakeTrendingRepositoryEntity
import com.example.data.repository.fakeTrendingRepositoryEntity2
import com.example.domain.model.TrendingGithubDomainModel
import junit.framework.TestCase.assertEquals
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
        val result = inputData.toTrendingGithubDomainModel()
        // then
        assertEquals(expectedOutput, result)
    }
}