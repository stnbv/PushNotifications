package com.example.pushnotifications.data.repository.user

interface IUserDeviceInfoRepository {
    suspend fun sendUserDeviceInfo(udid: String, fcmToken: String): Unit
}