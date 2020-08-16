package com.ramindu.weeraman.flowsample.domain

import com.ramindu.weeraman.flowsample.data.DogRepository
import javax.inject.Inject

class GetBreedListUseCaseImpl @Inject constructor(private val dogRepository: DogRepository):GetBreedListUseCase {
    override suspend fun retrieveBreedList() {
        dogRepository.getBreedList()
    }
}