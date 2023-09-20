package com.example.pushnotifications.di

import com.example.pushnotifications.MainActivityViewModel
import com.example.pushnotifications.presentation.device_info.DeviceInfoViewModel
import com.example.pushnotifications.presentation.auth.LoginViewModel
import com.example.pushnotifications.presentation.flowers_info.dialog.FlowersInfoDialogViewModel
import com.example.pushnotifications.presentation.flowers_shops.FlowersShopViewModel
import com.example.pushnotifications.presentation.flowers_info.screen.FlowersInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel {
        MainActivityViewModel(get())
    }

    viewModel {
        FlowersInfoViewModel(get())
    }

    viewModel {
        DeviceInfoViewModel(get(), get())
    }

    viewModel {
        FlowersShopViewModel(get())
    }

    viewModel {
        FlowersInfoDialogViewModel(get(), get())
    }

    viewModel{
        LoginViewModel(get())
    }
}
