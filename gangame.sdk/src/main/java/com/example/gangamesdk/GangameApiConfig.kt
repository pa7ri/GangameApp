package com.example.gangamesdk

import retrofit2.Retrofit

interface GangameApiConfig {
    fun setUpConfig(builder : Retrofit.Builder)
}