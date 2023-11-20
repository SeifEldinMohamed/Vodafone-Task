package com.example.data.repository.trending

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.data_sources.local.entities.TrendingRepositoriesEntity

val fakeTrendingRepositoryEntity = listOf(
    TrendingRepositoriesEntity(
        id = 12345,
        name = "seif",
        avatar = "https://fakeurl.com/avatar.png",
        description = "This is a fake repository.",
        forks = 10,
        language = "Kotlin",
        fullName = "fakeuser/fakerepo",
        stars = 50,
        url = "https://fakeurl.com/repo",
        owner = "Seif"
    )
)

val fakeTrendingRepositoryEntity2 = listOf(
    TrendingRepositoriesEntity(
        id = 12345,
        name = "seif",
        avatar = "https://fakeurl.com/avatar.png",
        description = "This is a fake repository.",
        forks = 10,
        language = "",
        fullName = "fakeuser/fakerepo",
        stars = 50,
        url = "https://fakeurl.com/repo",
        owner = "Seif"
    )
)


class FakeTrendingRepositoriesEntityPagingSource(private val fakeData: List<TrendingRepositoriesEntity>) :
    PagingSource<Int, TrendingRepositoriesEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TrendingRepositoriesEntity> {
        return try {
            LoadResult.Page(
                data = fakeData,
                prevKey = 1,
                nextKey = 2
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, TrendingRepositoriesEntity>): Int? {
        return null
    }

}