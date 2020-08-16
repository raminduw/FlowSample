package com.ramindu.weeraman.flowsample.domain.di

import com.ramindu.weeraman.flowsample.domain.GetBreedListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import com.ramindu.weeraman.flowsample.domain.GetBreedListUseCase as GetBreedListUseCase

@InstallIn(ActivityComponent::class)
@Module
abstract class InteractionModule {

    @ActivityScoped
    @Binds
    abstract fun bindGenerateEventUseCase(impl: GetBreedListUseCaseImpl): GetBreedListUseCase
}