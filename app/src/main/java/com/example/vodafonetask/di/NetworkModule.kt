package com.example.vodafonetask.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.data.data_sources.remote.IssuesApi
import com.example.data.data_sources.remote.RepoDetailsApi
import com.example.data.data_sources.remote.TrendingGithubApi
import com.example.vodafonetask.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(
        @ApplicationContext context: Context
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                .addInterceptor(ChuckerInterceptor(context))
                .build()
            )
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

    @Singleton
    @Provides
    fun provideIssuesApiService(retrofit: Retrofit): IssuesApi {
        return retrofit.create(IssuesApi::class.java)
    }
}