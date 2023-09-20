package com.example.pushnotifications.data.request

import com.google.gson.annotations.SerializedName

data class UserDeviceInfo(
    @SerializedName("udid") val udid: String,
    @SerializedName("fcm_token") val fcmToken: String,
)
