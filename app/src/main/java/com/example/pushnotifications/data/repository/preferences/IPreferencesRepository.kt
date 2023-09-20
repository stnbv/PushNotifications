package com.example.pushnotifications.data.repository.preferences

interface IPreferencesRepository {
    suspend fun saveFcmTokenInPrefs(fcmToken: String)
    suspend fun getFcmTokenFromPrefs(): String?
}