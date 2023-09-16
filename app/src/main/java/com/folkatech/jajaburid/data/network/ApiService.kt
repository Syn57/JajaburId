package com.folkatech.jajaburid.data.network

import retrofit2.http.GET

interface ApiService {
    @GET("52c41978-6e31-4ea3-b917-01899e3ed373")
    suspend fun getFood(): List<FoodResponseItem?>?
}