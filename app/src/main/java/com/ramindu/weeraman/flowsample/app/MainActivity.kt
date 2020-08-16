package com.ramindu.weeraman.flowsample.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ramindu.weeraman.flowsample.R
import com.ramindu.weeraman.flowsample.domain.GetBreedListUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var getBreedListUseCase: GetBreedListUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            getBreedListUseCase.retrieveBreedList().collect {
                Log.d("TAG", " Dog name : $it")
            }
        }
    }
}