package com.ramindu.weeraman.flowsample.app

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.ramindu.weeraman.flowsample.domain.GetBreedListUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class BreedViewModel @ViewModelInject constructor(
    private val getBreedListUseCase: GetBreedListUseCase,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    suspend fun  getAllBreeds(): Flow<String> {
      return getBreedListUseCase.retrieveBreedList()
    }
}