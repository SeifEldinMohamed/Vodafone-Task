package com.example.vodafonetask.di

import com.example.data.data_sources.remote.RepoDetailsApi
import com.example.data.data_sources.remote.TrendingGithubApi
import com.example.vodafonetask.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideTrendingRepositoriesApiService(retrofit: Retrofit): TrendingGithubApi {
        return retrofit.create(TrendingGithubApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepositoryDetailsApiService(retrofit: Retrofit): RepoDetailsApi {
        return retrofit.create(RepoDetailsApi::class.java)
    }
}