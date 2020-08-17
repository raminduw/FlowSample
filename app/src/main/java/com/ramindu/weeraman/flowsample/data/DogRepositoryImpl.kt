package com.ramindu.weeraman.flowsample.data

import com.ramindu.weeraman.flowsample.data.model.Dog
import com.ramindu.weeraman.flowsample.domain.Mapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class DogRepositoryImpl @Inject constructor(
    private val dogApi: DogApi,
    private val dogeMapper: Mapper<String, Dog>,
    private val dispatcher: CoroutineDispatcher
) : DogRepository {

    @ExperimentalCoroutinesApi
    override suspend fun getBreedList(): Flow<Dog> {
        val apiResponse = dogApi.getAllBreeds()

        return apiResponse.message.keys.toList().asFlow().onEach {
            delay(100) }.map {
            dogeMapper.transform(it)
        }.flowOn(dispatcher)
    }
}