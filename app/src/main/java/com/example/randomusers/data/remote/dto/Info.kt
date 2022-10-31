package com.example.randomusers.data.remote.dto

data class Info(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)