package com.example.gangamesdk

import com.example.gangamesdk.serializer.TopGameDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.junit.Test
import org.junit.Assert.*

class ModelUnitTest{

    private val JSON_DEAL = "{" +
    "\"internalName\": \"ELDRITCH\"," +
    "\"title\": \"Eldritch\"," +
    "\"metacriticLink\": \"/game/pc/eldritch\"," +
    "\"dealID\": \"Ivs4%2B%2FbAEBatKEftE9NH4e514bS9TPPyVjAMzIhbbc8%3D\"," +
    "\"storeID\": \"1\"," +
    "\"gameID\": \"102382\"," +
    "\"salePrice\": \"1.49\"," +
    "\"normalPrice\": \"14.99\"," +
    "\"isOnSale\": \"1\"," +
    "\"savings\": \"90.060040\"," +
    "\"metacriticScore\": \"77\"," +
    "\"steamRatingText\": \"Very Positive\"," +
    "\"steamRatingPercent\": \"88\"," +
    "\"steamRatingCount\": \"1229\"," +
    "\"steamAppID\": \"252630\"," +
    "\"releaseDate\": 1382313600," +
    "\"lastChange\": 1525454594," +
    "\"dealRating\": \"9.1\"," +
    "\"thumb\": \"https://steamcdn-a.akamaihd.net/steam/apps/252630/capsule_sm_120.jpg\"}"

    private val JSON_TOP_GAME = "{" +
        "\"appid\": 570," +
        "\"name\": \"Dota 2\"," +
        "\"developer\": \"Valve\"," +
        "\"publisher\": \"Valve\"," +
        "\"score_rank\": 68," +
        "\"positive\": 775368," +
        "\"negative\": 112165," +
        "\"userscore\": 87," +
        "\"owners\": \"100,000,000 .. 200,000,000\"," +
        "\"average_forever\": 29120," +
        "\"average_2weeks\": 1875," +
        "\"median_forever\": 722," +
        "\"median_2weeks\": 987," +
        "\"price\": \"0\"," +
        "\"initialprice\": \"0\"," +
        "\"discount\": \"0\"}"


    @Test
    fun dealParsingTest(){
        val dealGson = Gson()
        val deal = dealGson.fromJson(JSON_DEAL, Deal::class.java)

        assertEquals(deal.title, "Eldritch")
        assertEquals(deal.normalPrice, 14.99F)
        assertEquals(deal.salePrice, 1.49F)
        assertEquals(deal.metacriticScore, 77)
        assertEquals(deal.steamRating, 88)
        assertEquals(deal.thumb, "https://steamcdn-a.akamaihd.net/steam/apps/252630/capsule_sm_120.jpg")
    }

    @Test
    fun topGameParsingTest(){
        val topGameGson = GsonBuilder()
                .registerTypeAdapter(TopGame::class.java, TopGameDeserializer())
                .create()

        val topGame = topGameGson.fromJson(JSON_TOP_GAME, TopGame::class.java)


        assertEquals(topGame.title, "Dota 2")
        assertEquals(topGame.price, 0F)
        assertEquals(topGame.owners, "100,000,000 .. 200,000,000")
        assertEquals(topGame.publisher, "Valve")
        assertEquals(topGame.position, 68)
        assertEquals(topGame.steamRating, 87)
        //TODO : image for topGame
        assertEquals(topGame.thumb, "https://steamcdn-a.akamaihd.net/steam/apps/570/capsule_sm_120.jpg")
    }
}
