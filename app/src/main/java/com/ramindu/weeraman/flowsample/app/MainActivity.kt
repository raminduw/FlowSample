package com.ramindu.weeraman.flowsample.app

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
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

        loadData()
    }

    private fun loadData(){
        dogList.clear()
        recyclerViewDogs.clear()

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.getItemId()) {
            R.id.action_update -> {
                loadData()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}