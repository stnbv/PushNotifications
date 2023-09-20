package com.example.pushnotifications.utils

import android.Manifest.permission
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavDeepLinkBuilder
import com.example.pushnotifications.MainActivity
import com.example.pushnotifications.R
import com.example.pushnotifications.data.repository.preferences.IPreferencesRepository
import com.example.pushnotifications.domain.interactors.UserInteractor
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.util.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

const val CHANEL_ID = "CHANNEL_ID"
const val CHANNEL_NAME = "CHANNEL_NAME"
const val PARAM_NAME = "id"

class FirebaseMessagingService : FirebaseMessagingService() {

    private val prefs: IPreferencesRepository by inject()
    private val userDevicesInteractor: UserInteractor by inject()

    override fun onNewToken(token: String) {
        CoroutineScope(Dispatchers.IO).launch {
            prefs.saveFcmTokenInPrefs(token)
            userDevicesInteractor.sendUserDeviceInfo()
        }
    }

    override fun handleIntentOnMainThread(intent: Intent) = false

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        checkChannel()
        showNotification(
            title = message.notification?.title ?: "",
            description = message.notification?.body ?: "",
            flowerId = message.data[PARAM_NAME] ?: ""
        )
    }

    private fun checkChannel() {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(notificationManager)
    }

    private fun createNotificationChannel(notificationManager: NotificationManager) {
        val channel = NotificationChannel(CHANEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH)
        channel.enableLights(true)
        notificationManager.createNotificationChannel(channel)
    }

    private fun showNotification(
        title: String,
        description: String,
        flowerId: String
    ) {

        val notificationId = Date().time.toInt()

        val bundle = Bundle().apply {
            putString(PARAM_NAME, flowerId)
        }

        val pendingIntent: PendingIntent? = createIntent(bundle)
        pendingIntent.let { intent ->
            val notificationBuilder = NotificationCompat.Builder(this, CHANEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setColor(resources.getColor(R.color.pink, null))
                .setContentTitle(title)
                .setContentText(description)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setAutoCancel(true)
                .setContentIntent(intent)
                .build()

            if (ActivityCompat.checkSelfPermission(
                    applicationContext,
                    permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            NotificationManagerCompat.from(this@FirebaseMessagingService)
                .notify(CHANEL_ID, notificationId, notificationBuilder)
        }
    }

    private fun createIntent(bundle: Bundle) = NavDeepLinkBuilder(this)
        .setComponentName(MainActivity::class.java)
        .setGraph(R.navigation.main_graph)
        .setDestination(R.id.flowersInfoFragment)
        .setArguments(bundle)
        .createTaskStackBuilder().getPendingIntent(bundle.hashCode(), PendingIntent.FLAG_IMMUTABLE)
}
