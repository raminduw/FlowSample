package com.ramindu.weeraman.flowsample.domain

import com.ramindu.weeraman.flowsample.data.model.Dog
import kotlinx.coroutines.flow.Flow

interface GetBreedListUseCase {

    suspend fun retrieveBreedList(): Flow<Dog>
}