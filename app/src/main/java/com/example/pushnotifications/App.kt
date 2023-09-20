package com.example.pushnotifications

import android.app.Application
import com.example.pushnotifications.di.appModule
import com.example.pushnotifications.di.interactorModule
import com.example.pushnotifications.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule, viewModelsModule, interactorModule)
        }
    }
}
