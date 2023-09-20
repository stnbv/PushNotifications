package com.example.pushnotifications.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pushnotifications.domain.interactors.UserInteractor
import kotlinx.coroutines.launch

class LoginViewModel(val userInteractor: UserInteractor) : ViewModel() {

    fun sendUserDeviceInfo() {
        viewModelScope.launch {
            userInteractor.sendUserDeviceInfo()
        }
    }
}