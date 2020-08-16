package com.ramindu.weeraman.flowsample.data

import javax.inject.Inject

class DogRepositoryImpl @Inject constructor(private val dogApi: DogApi) : DogRepository {

    override suspend fun getBreedList() {
        dogApi.getAllBreeds()
    }
}