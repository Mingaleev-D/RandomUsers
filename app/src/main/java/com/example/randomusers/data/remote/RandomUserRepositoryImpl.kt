package com.example.randomusers.data.remote

import com.example.randomusers.data.mappers.toDomain
import com.example.randomusers.domain.model.RandomUser
import com.example.randomusers.domain.repository.RandomUserRepository
import com.example.randomusers.domain.util.Resource
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 31/10/2022
 */

class RandomUserRepositoryImpl @Inject constructor(
  private val randomUserApi: RandomUserApi
) : RandomUserRepository {
   override suspend fun getRandomUser(): Resource<RandomUser> {
      return try {
         Resource.Success(
            data = randomUserApi.getRandomUser().results.first().toDomain()
         )
      }catch (e: Exception) {
         Resource.Error(
            message = "Unknown Error"
         )
      }
   }

}