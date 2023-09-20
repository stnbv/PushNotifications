package com.example.pushnotifications.data.response

import com.example.pushnotifications.domain.models.FlowerModel
import com.example.pushnotifications.domain.models.FlowerShopModel
import com.example.pushnotifications.domain.models.FlowersDataModel
import com.google.gson.annotations.SerializedName

data class FlowersResponse(
    @SerializedName("data") val data: FlowerData
)

data class FlowerData(
    @SerializedName("shop") val shop: ShopData
)

data class ShopData(
    @SerializedName("name") val name: String,
    @SerializedName("link") val link: String,
    @SerializedName("avatar") val image: String,
    @SerializedName("items") val items: List<FlowerItemData>
)

data class FlowerItemData(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("photo") val photo: String,
    @SerializedName("price") val price: Int,
    @SerializedName("deliveryPrice") val deliveryPrice: Int
)

fun FlowersResponse.toModel() = FlowersDataModel(
    shopName = data.shop.name,
    shopLink = data.shop.link,
    shopImageLink = data.shop.image,
    flowers = data.shop.items.map {
        FlowerModel(
            id = it.id,
            bouquetName = it.name,
            bouquetImage = it.photo,
            price = it.price,
            deliveryPrice = it.deliveryPrice
        )
    }
)

data class FlowersShopsResponse(
    @SerializedName("data") val data: FlowersItems
)

data class FlowersItems(
    @SerializedName("items") val items: List<FlowerShopData>
)

data class FlowerShopData(
    @SerializedName("reviews_count") val reviewsCount: String,
    @SerializedName("name") val shopName: String,
    @SerializedName("bonus_percent") val bonusPercent: Int,
    @SerializedName("products") val products: List<ProductData>,
    @SerializedName("is_new_shop") val isNewShop: Boolean
)

data class ProductData(
    @SerializedName("photo") val photo: String
)

fun FlowerShopData.toModel() = FlowerShopModel(
    shopName = shopName,
    bonusPercent = bonusPercent,
    reviewsCount = reviewsCount,
    image = products[0].photo,
    isNewShop = isNewShop
)
