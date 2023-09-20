package com.example.pushnotifications.domain.models

data class FlowersDataModel(
    val shopName: String,
    val shopLink: String,
    val shopImageLink: String,
    val flowers: List<FlowerModel>
)

data class FlowerModel(
    val id: String,
    val bouquetName: String,
    val bouquetImage: String,
    val price: Int,
    val deliveryPrice: Int
)

data class FlowerShopModel(
    val shopName: String,
    val reviewsCount: String,
    val bonusPercent: Int,
    val image: String,
    val isNewShop: Boolean
)
