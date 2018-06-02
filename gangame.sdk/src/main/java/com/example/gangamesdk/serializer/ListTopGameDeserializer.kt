package com.example.gangamesdk.serializer

import com.example.gangamesdk.TopGame
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class ListTopGameDeserializer : JsonDeserializer<ArrayList<TopGame>> {
    override fun deserialize(json: JsonElement, typeOfT: Type?, context: JsonDeserializationContext?): ArrayList<TopGame> {
        val jsonTopGame =  json.asJsonObject
                .entrySet()
                .map { (_, json) ->
                    json.asJsonObject
                }
        val gsonTopGame = GsonBuilder()
                .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
                .create()
        val listTopGames = jsonTopGame.map { json ->
            gsonTopGame.fromJson(json, TopGame::class.java)
        }

        val arrayListTopGames : ArrayList<TopGame> = arrayListOf()
        arrayListTopGames.addAll(listTopGames)
        return arrayListTopGames
    }
}