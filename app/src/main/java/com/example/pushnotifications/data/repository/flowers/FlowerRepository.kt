package com.example.pushnotifications.data.repository.flowers

import com.example.pushnotifications.data.remote.FlowersApi
import com.example.pushnotifications.data.response.toModel
import com.example.pushnotifications.domain.models.FlowerShopModel
import com.example.pushnotifications.domain.models.FlowersDataModel

class FlowerRepository(private val flowersApi: FlowersApi) : IFlowerRepository {
    override suspend fun getFlowerData(): FlowersDataModel? {
        val request = flowersApi.getFlowersData()
        return if (request.isSuccessful) {
            request.body()?.toModel()
        } else null
    }

    override suspend fun getFlowerShopsData(): List<FlowerShopModel>? {
        val request = flowersApi.getFlowerShopData()
        return if (request.isSuccessful) {
            request.body()?.data?.items?.map {
                it.toModel()
            }
        } else null
    }
}
