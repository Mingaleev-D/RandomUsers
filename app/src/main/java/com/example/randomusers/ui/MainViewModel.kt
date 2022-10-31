package com.example.randomusers.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomusers.domain.model.RandomUser
import com.example.randomusers.domain.repository.RandomUserRepository
import com.example.randomusers.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 31/10/2022
 */
@HiltViewModel
class MainViewModel @Inject constructor(
   private val repository: RandomUserRepository
) :ViewModel(){

   private val _randomUserState = MutableLiveData<Resource<RandomUser>>()
   val randomUserState:LiveData<Resource<RandomUser>>
   get() = _randomUserState

   private val _isLoading = MutableLiveData<Boolean>()
   val isLoading:LiveData<Boolean>
   get() = _isLoading

   fun getRandomUser(){
      viewModelScope.launch {
         _isLoading.value = true
         _randomUserState.value = repository.getRandomUser()
         _isLoading.value = false
      }
   }
}