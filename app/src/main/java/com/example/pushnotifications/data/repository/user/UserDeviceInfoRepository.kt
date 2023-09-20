package com.example.pushnotifications.data.repository.user

import com.example.pushnotifications.data.remote.UserApi
import com.example.pushnotifications.data.request.UserDeviceInfo

class UserDeviceInfoRepository(val api: UserApi) : IUserDeviceInfoRepository {

    override suspend fun sendUserDeviceInfo(udid: String, fcmToken: String) {
        api.sendUserDeviceInfoData(UserDeviceInfo(udid = udid, fcmToken = fcmToken))
    }
}
