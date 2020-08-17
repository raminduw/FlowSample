package com.ramindu.weeraman.flowsample.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class DogRepositoryImpl @Inject constructor(private val dogApi: DogApi,private val dispatcher: CoroutineDispatcher) : DogRepository {

    @ExperimentalCoroutinesApi
    override suspend fun getBreedList(): Flow<String> {
        val apiResponse = dogApi.getAllBreeds()
        return apiResponse.message.keys.toList().asFlow().onEach { delay(100) }.flowOn(dispatcher)
    }
}