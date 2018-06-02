package com.example.gangamesdk

import com.google.gson.JsonParser
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Test

class RequestTest{

    @Test
    fun dealsRequest_success(){
        val apiService = GangameApiService()
        val response = apiService.apiClient.getDeals().execute()
        val deals = response.body()

        val parser = JsonParser()
        val jsonResponse = parser.parse(MockResponses.DEALS_RESPONSE).asJsonArray

        assertTrue(response.isSuccessful)

        deals?.let {
            assertEquals(deals.size, 4)
            deals.zip(jsonResponse).forEach { (deal, jsonDeal) ->
                with(jsonDeal.asJsonObject) {
                assertEquals(deal.title, this["title"].asString)
                assertEquals(deal.normalPrice, this["normalPrice"].asFloat)
                assertEquals(deal.salePrice, this["salePrice"].asFloat)
                assertEquals(deal.steamRating, this["steamRatingPercent"].asInt)
                assertEquals(deal.metacriticScore, this["metacriticScore"].asInt)
                assertEquals(deal.thumb, this["thumb"].asString)
            }
            }
        }
    }


    @Test
    fun topRatedRequest_success(){
        val apiService = GangameApiService()
        val response = apiService.apiClient.getTop100Games().execute()
        val games = response.body()

        val parser = JsonParser()
        val jsonResponse = parser.parse(MockResponses.TOP_100_GAMES)
                .asJsonObject
                .entrySet()
                .map{ (_,json) ->
                    json.asJsonObject

                }
        assertTrue(response.isSuccessful)

        games?.let {
            assertEquals(games.size, 2)
            games.zip(jsonResponse).forEach { (topGame, jsonDeal) ->
                with(jsonDeal.asJsonObject) {
                    assertEquals(topGame.title, this["name"].asString)
                    assertEquals(topGame.publisher, this["publisher"].asString)
                    assertEquals(topGame.position, this["score_rank"].asInt)
                    assertEquals(topGame.steamRating, this["userscore"].asInt)
                    assertEquals(topGame.owners, this["owners"].asString)
                    assertEquals(topGame.thumb, "https://steamcdn-a.akamaihd.net/steam/apps/${this["appid"].asInt}/capsule_sm_120.jpg")
                }
            }
        }
    }
}