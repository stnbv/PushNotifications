package com.example.pushnotifications.data.remote

import com.example.pushnotifications.data.request.UserDeviceInfo
import com.example.pushnotifications.data.response.UserDeviceInfoResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PUT

interface UserApi {

    @PUT("devices")
    suspend fun sendUserDeviceInfoData(@Body userDeviceInfo: UserDeviceInfo): Response<UserDeviceInfoResponse>
}