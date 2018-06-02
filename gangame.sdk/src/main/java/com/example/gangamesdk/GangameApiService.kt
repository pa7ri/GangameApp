package com.example.gangamesdk


import com.example.gangamesdk.serializer.ListTopGameDeserializer
import com.example.gangamesdk.serializer.TopGameDeserializer
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class GangameApiService(apiConfig : GangameApiConfig = GangameClientConfig()){

    val apiClient : RetrofitGangameAPI

    init {
        val tokenType = object : TypeToken<ArrayList<TopGame>>(){}.type
        val gsonTopGame = GsonBuilder()
                .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
                .registerTypeAdapter(tokenType ,ListTopGameDeserializer())
                .create()

        val apiClientConfig =
                Retrofit.Builder()
                        .baseUrl(Routes.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gsonTopGame))
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        apiConfig.setUpConfig(apiClientConfig)
        apiClient = apiClientConfig.build().create(RetrofitGangameAPI::class.java)
    }
}