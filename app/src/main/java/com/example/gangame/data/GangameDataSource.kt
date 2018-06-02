package com.example.gangame.data

import com.example.gangame.Deal
import com.example.gangame.TopGame
import com.example.gangamesdk.GangameApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object GangameDataSource{

    val apiService = GangameApiService()

    fun getDeals(): Observable<ArrayList<Deal>> {
        return apiService.apiClient
                .getDealsObservable()
                .map { listDeal ->
                    val deals = listDeal.map { deal -> DealMapper.fromSdk(deal) }
                    val arrayListDeals = arrayListOf<Deal>()
                    arrayListDeals.addAll(deals)
                    arrayListDeals
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }

    fun getTopRated(): Observable<ArrayList<TopGame>> {
        return apiService.apiClient
                .getTop100GamesObservable()
                .map { listTopGames ->
                    val topGames = listTopGames.mapIndexed { index, topGame ->
                        TopGameMapper.fromSdk(topGame, index+1)
                    }
                    val arrayListTopGames = arrayListOf<TopGame>()
                    arrayListTopGames.addAll(topGames)
                    arrayListTopGames
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }

    fun getMostOwned(): Observable<ArrayList<TopGame>> {
        return apiService.apiClient
                .getMostOwnedGamesObservable()
                .map { listTopGames ->
                    val topGames = listTopGames.mapIndexed { index, topGame ->
                        TopGameMapper.fromSdk(topGame, index+1)
                    }
                    val arrayListTopGames = arrayListOf<TopGame>()
                    arrayListTopGames.addAll(topGames)
                    arrayListTopGames
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}