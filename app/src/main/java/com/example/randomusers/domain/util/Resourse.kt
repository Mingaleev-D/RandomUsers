package com.example.randomusers.domain.util

/**
 * @author : Mingaleev D
 * @data : 31/10/2022
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
   class Success<T>(data: T?) : Resource<T>(data)
   class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}