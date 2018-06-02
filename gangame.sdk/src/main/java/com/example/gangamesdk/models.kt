package com.example.gangamesdk

import com.google.gson.annotations.SerializedName

data class Deal(val title : String,
                val normalPrice : Float,
                val salePrice : Float,
                val metacriticScore : Int,
                @SerializedName("steamRatingPercent") val steamRating : Int,
                val thumb : String)

data class TopGame(@SerializedName("name") val title : String,
                   val owners : String,
                   val publisher : String,
                   @SerializedName("userscore") val steamRating: Int,
                   @SerializedName("score_rank") val position: Int,
                   val price : Float,
                   var thumb : String)
