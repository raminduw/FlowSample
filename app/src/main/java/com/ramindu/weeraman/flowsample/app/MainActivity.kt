package com.ramindu.weeraman.flowsample.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.ramindu.weeraman.flowsample.R
import com.ramindu.weeraman.flowsample.domain.GetBreedListUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val breedViewModel: BreedViewModel by viewModels()

    @Inject
    lateinit var getBreedListUseCase: GetBreedListUseCase

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launchWhenCreated {
            breedViewModel.getAllBreeds().onStart {
                Log.d("TAG", "DOG Name : START")
            }.catch {
                Log.d("TAG", "DOG Name : ERROR")
            }.onCompletion {
                Log.d("TAG", "DOG Name : END")
            }.collect {
                Log.d("TAG", "DOG Name : $it")
            }
        }
    }
}