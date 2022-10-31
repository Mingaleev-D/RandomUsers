package com.example.randomusers.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.randomusers.databinding.ActivityMainBinding
import com.example.randomusers.domain.extension.load
import com.example.randomusers.domain.model.RandomUser
import com.example.randomusers.domain.repository.RandomUserRepository
import com.example.randomusers.domain.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding
   private val viewmodel by viewModels<MainViewModel>()

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = ActivityMainBinding.inflate(layoutInflater)
      setContentView(binding.root)

      initListener()
      subscribeViewModel()
      initData()
   }

   private fun initListener() {
      with(binding) {
         btnUpdateRandom.setOnClickListener {
            viewmodel.getRandomUser()
         }
      }
   }


   private fun initData() {
      viewmodel.getRandomUser()
   }

   private fun subscribeViewModel() {
      viewmodel.randomUserState.observe(this) {
         when (it) {
            is Resource.Success -> it.data?.let { it1 -> bindUserData(it1) }
            is Resource.Error -> Unit
         }
      }
      viewmodel.isLoading.observe(this) {
         handleLoadingState(it)
      }
   }
   private fun bindUserData(randomUser: RandomUser){
      with(binding) {
         userName.text = randomUser.name
         userImage.load(randomUser.phone)
      }
   }

   private fun handleLoadingState(isLoading: Boolean) {
      with(binding) {
         if (isLoading) {
            userGroupData.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
         } else {
            progressBar.visibility = View.GONE
            userGroupData.visibility = View.VISIBLE

         }

      }
   }
}