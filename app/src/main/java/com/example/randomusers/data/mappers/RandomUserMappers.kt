package com.example.randomusers.data.mappers

import com.example.randomusers.data.remote.dto.Result
import com.example.randomusers.domain.model.RandomUser

/**
 * @author : Mingaleev D
 * @data : 31/10/2022
 */

fun Result.toDomain(): RandomUser {
   return RandomUser(
      name = "${this.name.first} ${this.name.last}",
      email = this.email,
      birthday = this.dob.date,
      age = this.dob.age,
      address = "${this.location.state} ${this.location.city}",
      phone = this.phone,
      password = this.login.password,
      photo = this.picture.large
   )
}