package com.example.presentation.mapper

import com.example.domain.model.RepositoryDetailsDomainModel
import com.example.presentation.model.RepositoryDetailsUiModel
import com.example.presentation.screens.details.fakeDetailsDomainModel
import com.example.presentation.screens.details.fakeDetailsUiModel
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ToRepositoryDetailsUiModelMapperTest(
    private val inputData: RepositoryDetailsDomainModel,
    private val expectedOutput: RepositoryDetailsUiModel
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: DataModel = {0}, Expected = {1}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(
                    fakeDetailsDomainModel,
                    fakeDetailsUiModel
                ),
            )
        }
    }

    @Test
    fun `toRepositoryDetailsUIModel(), when RepositoryDetailsDomainModel then it should return RepositoryDetailsUIModel`() {
        // when
        val result = inputData.toRepositoryDetailsUIModel()
        // then
        assertEquals(expectedOutput, result)
    }
}