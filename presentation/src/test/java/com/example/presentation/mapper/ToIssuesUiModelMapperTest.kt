package com.example.presentation.mapper

import com.example.domain.model.IssuesDomainModel
import com.example.presentation.model.IssuesUiModel
import com.example.presentation.screens.issues.fakeIssuesDomainModelList
import com.example.presentation.screens.issues.fakeIssuesUiModelList
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ToIssuesUiModelMapperTest(
    private val inputData: List<IssuesDomainModel>,
    private val expectedOutput: List<IssuesUiModel>
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: DataModel = {0}, Expected = {1}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(
                    fakeIssuesDomainModelList,
                    fakeIssuesUiModelList
                ),
            )
        }
    }

    @Test
    fun `toIssuesUiModel(), when IssuesDomainModel then it should return IssuesUiModel`() {
        // when
        val result = inputData.map { it.toIssuesUiModel() }
        // then
        assertEquals(expectedOutput, result)
    }
}