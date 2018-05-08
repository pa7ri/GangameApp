package com.example.gangame.owned

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.commons.BaseListFragment
import com.example.commons.DataBindingRecyclerAdapter
import com.example.gangame.BR
import com.example.gangame.R
import com.example.gangame.TopGame


class TopOwnedFragment : BaseListFragment() {
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopGame>(BR.topGame, R.layout.item_top_game)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (listAdapter as DataBindingRecyclerAdapter<TopGame>).items.addAll(getDummyTopGame())
        listAdapter.notifyDataSetChanged()
    }


    private fun getDummyTopGame():ArrayList<TopGame>{
        return arrayListOf(TopGame(
                "Counter Strike",
                "11",
                123,
                "Manolo",
                8.99F,
                23,
                "http://pre12.deviantart.net/505c/th/pre/f/2015/275/c/5/pokemon_azurill_298_lineart_farbig_v2_by_wallpaperzero-d9bnopw.png"))
    }
}