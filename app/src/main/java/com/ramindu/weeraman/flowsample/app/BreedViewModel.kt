package com.ramindu.weeraman.flowsample.app

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.ramindu.weeraman.flowsample.domain.GetBreedListUseCase
import kotlinx.coroutines.flow.*

class BreedViewModel @ViewModelInject constructor(
    private val getBreedListUseCase: GetBreedListUseCase
) : ViewModel() {

    suspend fun getAllBreeds(): Flow<String> {
        return getBreedListUseCase.retrieveBreedList()
    }
}