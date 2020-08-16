package com.ramindu.weeraman.flowsample.domain

import com.ramindu.weeraman.flowsample.data.DogRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBreedListUseCaseImpl @Inject constructor(private val dogRepository: DogRepository) :
    GetBreedListUseCase {

    override suspend fun retrieveBreedList(): Flow<String> {
        return dogRepository.getBreedList()
    }
}