package com.webskitters.client.testhiltexample.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager

@Module
@InstallIn(FragmentComponent::class)
class NetworkModule {

}