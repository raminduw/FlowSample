package com.ramindu.weeraman.flowsample.data.di

import com.ramindu.weeraman.flowsample.data.DogMapper
import com.ramindu.weeraman.flowsample.data.DogRepository
import com.ramindu.weeraman.flowsample.data.DogRepositoryImpl
import com.ramindu.weeraman.flowsample.data.model.Dog
import com.ramindu.weeraman.flowsample.domain.Mapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
abstract class MapperModule {

    @Singleton
    @Binds
    abstract fun bindDogMapper(impl: DogMapper): Mapper<String, Dog>
}