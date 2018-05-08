package com.example.gangamesdk

import com.example.gangamesdk.serializer.TopGameDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class GangameApiService{
    private val apiClient : RetrofitGangameAPI
    init {
        val gson = GsonBuilder()
                .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
                .create()
        val apiClientConfig =
                Retrofit.Builder()
                .baseUrl(Routes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        apiClient = apiClientConfig.create(RetrofitGangameAPI::class.java)
    }
}