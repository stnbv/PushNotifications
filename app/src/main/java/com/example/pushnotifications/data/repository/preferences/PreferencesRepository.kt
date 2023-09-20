package com.example.pushnotifications.data.repository.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class PreferencesRepository(
    private val dataStore: DataStore<Preferences>
):IPreferencesRepository {

    private val FCM_TOKEN = stringPreferencesKey("token")

    override suspend fun saveFcmTokenInPrefs(fcmToken: String) {
        dataStore.edit { preferences ->
            preferences[FCM_TOKEN] = fcmToken
        }
    }

    override suspend fun getFcmTokenFromPrefs(): String? {
        return dataStore.data.map {
            it[FCM_TOKEN]
        }.first()
    }
}