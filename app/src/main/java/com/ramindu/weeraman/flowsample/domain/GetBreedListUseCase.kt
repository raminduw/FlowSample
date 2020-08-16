package com.ramindu.weeraman.flowsample.domain

import kotlinx.coroutines.flow.Flow

interface GetBreedListUseCase {

    suspend fun retrieveBreedList(): Flow<String>
}