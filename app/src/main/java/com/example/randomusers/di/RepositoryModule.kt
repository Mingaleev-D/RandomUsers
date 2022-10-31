package com.example.randomusers.di

import com.example.randomusers.data.remote.RandomUserRepositoryImpl
import com.example.randomusers.domain.repository.RandomUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author : Mingaleev D
 * @data : 31/10/2022
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

   @Binds
   @Singleton
   abstract fun bindRandomUserRepository(
      randomUserRepositoryImpl: RandomUserRepositoryImpl
   ):RandomUserRepository
}