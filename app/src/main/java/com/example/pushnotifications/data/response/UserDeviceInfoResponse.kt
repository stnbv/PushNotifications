package com.example.pushnotifications.data.response

import com.google.gson.annotations.SerializedName

data class UserDeviceInfoResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("udid") val udid: String,
    @SerializedName("fcmToken") val fcmToken: String,
)