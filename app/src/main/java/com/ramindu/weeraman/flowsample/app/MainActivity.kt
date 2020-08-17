package com.ramindu.weeraman.flowsample.app

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ramindu.weeraman.flowsample.R
import com.ramindu.weeraman.flowsample.data.model.Dog
import com.ramindu.weeraman.flowsample.domain.GetBreedListUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val breedViewModel: BreedViewModel by viewModels()

    @Inject
    lateinit var getBreedListUseCase: GetBreedListUseCase

    var dogList: MutableList<String> = mutableListOf()

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launchWhenCreated {
            breedViewModel.getAllBreeds().onStart {
                progressBar.visibility = VISIBLE
            }.catch {
                progressBar.visibility = GONE
            }.onCompletion {
                progressBar.visibility = GONE
            }.collect { dog ->
                updateList(dog)
            }
        }
    }

    private fun updateList(dog: Dog) {
        dogList.add(dog.name)
        recyclerViewDogs.withModels {
            dogList.forEach {
                dogModel {
                    id(it)
                    name(it)
                }
            }
        }
    }
}