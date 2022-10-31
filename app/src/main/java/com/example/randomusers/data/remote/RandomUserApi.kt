package com.example.randomusers.data.remote

import com.example.randomusers.data.remote.dto.ResponseDto
import retrofit2.http.GET

/**
 * @author : Mingaleev D
 * @data : 31/10/2022
 */

interface RandomUserApi {

   @GET("api")
   suspend fun getRandomUser(): ResponseDto
}