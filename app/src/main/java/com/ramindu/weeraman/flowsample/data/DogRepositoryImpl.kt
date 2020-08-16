package com.ramindu.weeraman.flowsample.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class DogRepositoryImpl @Inject constructor(private val dogApi: DogApi) : DogRepository {

    override suspend fun getBreedList(): Flow<String> {
        val apiResponse = dogApi.getAllBreeds()
        return apiResponse.message.keys.toList().asFlow()
    }
}