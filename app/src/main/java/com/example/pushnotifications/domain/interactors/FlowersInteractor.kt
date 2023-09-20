package com.example.pushnotifications.domain.interactors

import com.example.pushnotifications.data.repository.flowers.IFlowerRepository

class FlowersInteractor(private val flowersRepository: IFlowerRepository) {

    suspend fun getFlowerData() = flowersRepository.getFlowerData()

    suspend fun getFlowerShopsData() = flowersRepository.getFlowerShopsData()
}
