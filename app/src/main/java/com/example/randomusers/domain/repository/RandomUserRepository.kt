package com.example.randomusers.domain.repository

import com.example.randomusers.domain.model.RandomUser
import com.example.randomusers.domain.util.Resource

/**
 * @author : Mingaleev D
 * @data : 31/10/2022
 */

interface RandomUserRepository {

   suspend fun getRandomUser():Resource<RandomUser>
}