package com.example.data.mapper.issues

import com.example.data.data_sources.remote.dto.issues.IssuesDataModelItem
import com.example.data.mapper.toIssuesDomainModel
import com.example.data.repository.issues.fakeIssuesDataModelList
import com.example.data.repository.issues.fakeIssuesDomainModelList
import com.example.domain.model.IssuesDomainModel
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ToIssuesDomainModelMapperTest(
    private val inputData: List<IssuesDataModelItem>,
    private val expectedOutput: List<IssuesDomainModel>
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: DataModel = {0}, Expected = {1}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(
                    fakeIssuesDataModelList,
                    fakeIssuesDomainModelList
                )
            )
        }
    }
    @Test
    fun `toIssuesDomainModel(), when IssuesDataModel then it should return IssuesDomainModel`() {
        // when
        val result = inputData.map { it.toIssuesDomainModel() }
        // then
       assertEquals(expectedOutput, result)
    }
}