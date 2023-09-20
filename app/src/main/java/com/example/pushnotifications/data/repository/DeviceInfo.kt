package com.example.pushnotifications.data.repository

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings

class DeviceInfo(private val context: Context) {

    val deviceId: String
        @SuppressLint("HardwareIds")
        get() {
            return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        }
}
