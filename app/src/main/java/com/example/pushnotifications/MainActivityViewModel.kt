package com.example.pushnotifications

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pushnotifications.data.repository.preferences.IPreferencesRepository
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.launch

class MainActivityViewModel(private val preferencesRepositoryImpl: IPreferencesRepository) : ViewModel() {

    fun initFirebaseMessaging() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                return@OnCompleteListener
            }
            viewModelScope.launch {
                preferencesRepositoryImpl.saveFcmTokenInPrefs(task.result.toString())
            }
        })
    }
}
