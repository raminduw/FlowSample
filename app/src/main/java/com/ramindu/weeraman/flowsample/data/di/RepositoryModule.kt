package com.ramindu.weeraman.flowsample.data.di

import com.ramindu.weeraman.flowsample.data.DogRepository
import com.ramindu.weeraman.flowsample.data.DogRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindUserDataRepository(impl: DogRepositoryImpl): DogRepository
}