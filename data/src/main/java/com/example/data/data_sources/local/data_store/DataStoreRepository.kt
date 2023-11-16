package com.example.data.data_sources.local.data_store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.example.data.Constants.Companion.PREFERENCES_IS_FIRST_TIME
import com.example.data.Constants.Companion.PREFERENCES_NAME
import kotlinx.coroutines.flow.first

class DataStorePreference(private val context: Context) {

    companion object {
        private object PreferenceKeys {
            val isFirstTime = booleanPreferencesKey(PREFERENCES_IS_FIRST_TIME)
        }
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
            name = PREFERENCES_NAME
        )
    }

    suspend fun saveIsFirstTime(isFirstTime: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferenceKeys.isFirstTime] = isFirstTime
        }
    }

    suspend fun readIsFirstTime(): Boolean = context.dataStore.data.first()[PreferenceKeys.isFirstTime] ?: true

}