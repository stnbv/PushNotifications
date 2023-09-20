package com.example.pushnotifications.domain.interactors

import com.example.pushnotifications.data.repository.DeviceInfo
import com.example.pushnotifications.data.repository.preferences.IPreferencesRepository
import com.example.pushnotifications.data.repository.user.IUserDeviceInfoRepository

class UserInteractor(
    private val userRepository: IUserDeviceInfoRepository,
    private val deviceInfo: DeviceInfo,
    private val preferencesRepository: IPreferencesRepository
) {
    suspend fun sendUserDeviceInfo() {
        val udid = deviceInfo.deviceId
        val fcmToken = preferencesRepository.getFcmTokenFromPrefs()
        if (udid.isNotBlank() && !fcmToken.isNullOrBlank()) {
            userRepository.sendUserDeviceInfo(udid, fcmToken)
        }
    }
}
