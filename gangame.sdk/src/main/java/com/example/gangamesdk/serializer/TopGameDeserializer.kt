package com.example.gangamesdk.serializer

import com.example.gangamesdk.TopGame
import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class TopGameDeserializer : JsonDeserializer<TopGame>{
    companion object {
        const val BASE_IMG_URL = "https://steamcdn-a.akamaihd.net/steam/apps/%s/capsule_sm_120.jpg"
    }
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): TopGame {
        val gsontopGame = Gson()
        val topGame = gsontopGame.fromJson(json, TopGame::class.java)
        val appId = json.asJsonObject["appid"] //to get 'appid' atributte

        val thumb = String.format(BASE_IMG_URL, appId)

        topGame.thumb = thumb
        return topGame
    }

}