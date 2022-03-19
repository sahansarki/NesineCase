package com.example.nesinecase.di

import com.example.nesinecase.data.repository.PostRepositoryImpl
import com.example.nesinecase.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
interface RemoteModule {

    @Binds
    @com.example.nesinecase.di.PostRepositoryImpl
    fun bindPostsRepository(postRepositoryImpl: PostRepositoryImpl): PostRepository
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PostRepositoryImpl
