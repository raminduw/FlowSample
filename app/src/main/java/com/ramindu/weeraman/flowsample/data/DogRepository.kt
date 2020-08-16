package com.ramindu.weeraman.flowsample.data

import kotlinx.coroutines.flow.Flow

interface DogRepository {

    suspend fun getBreedList(): Flow<String>
}