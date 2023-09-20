package com.example.pushnotifications.di

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.pushnotifications.USER_PREFERENCES_NAME
import com.example.pushnotifications.data.provider.OkHttpProvider
import com.example.pushnotifications.data.remote.FlowersApi
import com.example.pushnotifications.data.remote.UserApi
import com.example.pushnotifications.data.repository.DeviceInfo
import com.example.pushnotifications.data.repository.flowers.FlowerRepository
import com.example.pushnotifications.data.repository.flowers.IFlowerRepository
import com.example.pushnotifications.data.repository.preferences.IPreferencesRepository
import com.example.pushnotifications.data.repository.preferences.PreferencesRepository
import com.example.pushnotifications.data.repository.user.IUserDeviceInfoRepository
import com.example.pushnotifications.data.repository.user.UserDeviceInfoRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    factory { OkHttpProvider() }
    single { get<OkHttpProvider>().getHttpClient() }

    single<IFlowerRepository> { (FlowerRepository(get())) }

    single<IUserDeviceInfoRepository> { (UserDeviceInfoRepository(get())) }

    single<IPreferencesRepository> { (PreferencesRepository(get())) }

    single {
        DeviceInfo(androidContext())
    }

    single {
        Retrofit.Builder()
            .baseUrl("http://46.35.228.254:3005/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FlowersApi::class.java)
    }


    single {
        Retrofit.Builder()
            .baseUrl("http://46.35.228.254:3005/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

    single {
        PreferenceDataStoreFactory.create(
            produceFile = { androidContext().preferencesDataStoreFile(USER_PREFERENCES_NAME) }
        )
    }
}
