package com.example.pushnotifications.di

import com.example.pushnotifications.domain.interactors.FlowersInteractor
import com.example.pushnotifications.domain.interactors.UserInteractor
import org.koin.dsl.module

val interactorModule = module {

    factory { FlowersInteractor(get()) }

    factory { UserInteractor(get(), get(), get()) }
}
