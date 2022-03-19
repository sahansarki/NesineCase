package com.example.nesinecase.di

import com.example.nesinecase.data.api.PostAPI
import com.example.nesinecase.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServerModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        RetrofitClient.getInstance()

    @Singleton
    @Provides
    fun providePostAPI(retrofit: Retrofit): PostAPI =
        retrofit.create(PostAPI::class.java)


}
