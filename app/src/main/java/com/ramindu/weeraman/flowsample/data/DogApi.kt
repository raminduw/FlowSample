package com.ramindu.weeraman.flowsample.data

import com.ramindu.weeraman.flowsample.data.model.ApiResponse
import retrofit2.http.GET

interface DogApi {

    @GET("breeds/list/all")
    suspend fun getAllBreeds(): ApiResponse<Map<String, List<String>>>
}