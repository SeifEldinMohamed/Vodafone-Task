package com.example.data.data_sources.local

import androidx.room.TypeConverter
import com.example.data.data_sources.local.entities.TrendingRepositoriesEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RepositoriesTypeConverter {

    @TypeConverter
    fun trendingRepositoriesToString(trendingRepositoriesResponse: List<TrendingRepositoriesEntity>):String {
        return Gson().toJson(trendingRepositoriesResponse)
    }
    @TypeConverter
    fun fromStringToTrendingRepositories(data: String):List<TrendingRepositoriesEntity> {
        val listType = object : TypeToken<List<TrendingRepositoriesEntity>>(){}.type
        return Gson().fromJson(data,listType)
    }
}