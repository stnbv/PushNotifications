package com.example.pushnotifications.presentation.device_info

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pushnotifications.data.repository.DeviceInfo
import com.example.pushnotifications.data.repository.preferences.IPreferencesRepository
import kotlinx.coroutines.launch

class DeviceInfoViewModel(
    private val prefs: IPreferencesRepository,
    deviceInfo: DeviceInfo
) : ViewModel() {

    val udid = MutableLiveData<String>()
    val fcmToken = MutableLiveData<String>()

    init {
        viewModelScope.launch {
            fcmToken.postValue(prefs.getFcmTokenFromPrefs())
        }
        udid.postValue(deviceInfo.deviceId)
    }
}
