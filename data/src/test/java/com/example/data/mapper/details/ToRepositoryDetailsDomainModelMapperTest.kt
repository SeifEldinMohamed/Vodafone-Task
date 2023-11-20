package com.example.data.mapper.details

import com.example.data.data_sources.remote.dto.repo_details.RepositoryDetailsDataModel
import com.example.data.mapper.toRepositoryDetailsDomainModel
import com.example.data.repository.details.fakeDetailsDataModel
import com.example.data.repository.details.fakeDetailsDomainModel
import com.example.domain.model.RepositoryDetailsDomainModel
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ToRepositoryDetailsDomainModelMapperTest(
    private val inputData: RepositoryDetailsDataModel,
    private val expectedOutput: RepositoryDetailsDomainModel
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: DataModel = {0}, Expected = {1}")
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(
                    fakeDetailsDataModel,
                    fakeDetailsDomainModel
                )
            )
        }
    }
    @Test
    fun `toRepositoryDetailsDomainModel(), when RepositoryDetailsDataModel then it should return RepositoryDetailsDomainModel`() {
        // when
        val result = inputData.toRepositoryDetailsDomainModel()
        // then
       assertEquals(expectedOutput, result)
    }
}