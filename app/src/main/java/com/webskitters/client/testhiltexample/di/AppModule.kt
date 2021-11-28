package com.webskitters.client.testhiltexample.di

import android.content.Context
import com.webskitters.client.testhiltexample.data.network.ApiService
import com.webskitters.client.testhiltexample.data.network.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideApi(
        @ApplicationContext context: Context,
        remoteDataSource: RemoteDataSource
    ): ApiService {
        return remoteDataSource.buildApi(ApiService::class.java, context)
    }
}