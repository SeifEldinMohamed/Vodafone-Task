package com.example.data

import com.example.data.mapper.FromTrendingGithubDataModelToTrendingGithubDomainModelMapperTest
import com.example.data.repository.TrendingRepositoryImpTest
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

@RunWith(Suite::class)
@SuiteClasses(
    FromTrendingGithubDataModelToTrendingGithubDomainModelMapperTest::class,
    TrendingRepositoryImpTest::class
)
class TestSuite