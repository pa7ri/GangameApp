package com.example.gangame.data

import com.example.gangame.TopGame

object TopGameMapper {
        fun fromSdk(topGame: com.example.gangamesdk.TopGame, pos : Int) : TopGame {
            return  TopGame(topGame.title,
                    topGame.owners,
                    topGame.steamRating,
                    topGame.publisher,
                    topGame.price,
                    pos,
                    topGame.thumb)
    }
}