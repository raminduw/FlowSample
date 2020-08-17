package com.ramindu.weeraman.flowsample.data

import com.ramindu.weeraman.flowsample.data.model.Dog
import kotlinx.coroutines.flow.Flow

interface DogRepository {

    suspend fun getBreedList(): Flow<Dog>
}