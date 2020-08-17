package com.ramindu.weeraman.flowsample.app

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ramindu.weeraman.flowsample.R
import com.ramindu.weeraman.flowsample.domain.GetBreedListUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
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
                progressBar_cyclic.visibility = VISIBLE
            }.catch {
                Log.d("TAG", "DOG Name : ERROR")
                progressBar_cyclic.visibility = GONE
            }.onCompletion {
                progressBar_cyclic.visibility = GONE
            }.collect {
                Log.d("TAG", "DOG Name : $it")
            }
        }
    }
}