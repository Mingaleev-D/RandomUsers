package com.example.randomusers.domain.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * @author : Mingaleev D
 * @data : 31/10/2022
 */

fun ImageView.load(url:String){
   Glide.with(this).load(url).into(this)
}