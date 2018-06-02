package com.example.gangame.data

import com.example.gangame.Deal

object DealMapper {
    fun fromSdk(deal: com.example.gangamesdk.Deal) : Deal {
        return  Deal(deal.title,
                deal.normalPrice,
                deal.salePrice,
                deal.metacriticScore,
                deal.steamRating,
                deal.thumb
                )
    }
}