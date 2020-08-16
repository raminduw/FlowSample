package com.ramindu.weeraman.flowsample.data

interface DogRepository {

    suspend fun getBreedList()
}