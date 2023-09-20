package com.example.pushnotifications.data.remote

import com.example.pushnotifications.data.response.FlowersResponse
import com.example.pushnotifications.data.response.FlowersShopsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FlowersApi {
    @GET("json_statics")
    suspend fun getFlowersData(@Query("file") file: String = "item-flower"): Response<FlowersResponse>

    @GET("json_statics")
    suspend fun getFlowerShopData(@Query("file") file: String = "shops"): Response<FlowersShopsResponse>
}
