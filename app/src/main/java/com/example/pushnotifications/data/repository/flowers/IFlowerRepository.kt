package com.example.pushnotifications.data.repository.flowers

import com.example.pushnotifications.domain.models.FlowerShopModel
import com.example.pushnotifications.domain.models.FlowersDataModel

interface IFlowerRepository {
    suspend fun getFlowerData(): FlowersDataModel?
    suspend fun getFlowerShopsData(): List<FlowerShopModel>?
}
