package com.example.presentation.mapper

import com.example.domain.model.TrendingGithubDomainModel
import com.example.presentation.model.TrendingGithubUiModel
import com.example.presentation.screens.trending_screen.fakeTrendingGithubListDomainModel
import com.example.presentation.screens.trending_screen.fakeTrendingGithubListUiModel
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ToTrendingGithubUiModelMapperTest(
    private val inputData: List<TrendingGithubDomainModel>,
    private val expectedOutput: List<TrendingGithubUiModel>
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: DataModel = {0}, Expected = {1}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(
                    fakeTrendingGithubListDomainModel,
                    fakeTrendingGithubListUiModel
                ),
            )
        }
    }

    @Test
    fun `toTrendingGithubUIModel(), when TrendingGithubDomainModel then it should return TrendingGithubUIModel`() {
        // when
        val result = inputData.map { it.toTrendingGithubUIModel() }
        // then
        assertEquals(expectedOutput, result)
    }
}