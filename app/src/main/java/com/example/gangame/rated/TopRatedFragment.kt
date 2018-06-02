package com.example.gangame.rated

import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.commons.BaseListFragment
import com.example.commons.DataBindingRecyclerAdapter
import com.example.gangame.BR
import com.example.gangame.R
import com.example.gangame.TopGame
import com.example.gangame.data.GangameDataSource


class TopRatedFragment: BaseListFragment() {
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopGame>(BR.topGame, R.layout.item_top_game)
    }

    override fun updateItems() {
        GangameDataSource
                .getTopRated()
                .subscribe({ list ->
                    replaceItems(list)
                },{error ->
                    showError(error)
                })
    }

    private fun replaceItems(list:List<TopGame>) {
        with(listAdapter as DataBindingRecyclerAdapter<TopGame>){
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }
    }

    private fun showError(error: Throwable) {
        Log.e("Error update data", error.message)
    }
}