package com.example.gangame.deals

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.commons.BaseListFragment
import com.example.commons.DataBindingRecyclerAdapter
import com.example.gangame.BR
import com.example.gangame.Deal
import com.example.gangame.R


class DealsFragment: BaseListFragment() {
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<Deal>(BR.deal, R.layout.item_deal)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (listAdapter as DataBindingRecyclerAdapter<Deal>).items.addAll(getDummyDeals())
        listAdapter.notifyDataSetChanged()
    }

    private fun getDummyDeals():ArrayList<Deal>{
        return arrayListOf(Deal(
          "Counter Strike",
                0.99F,
                9.99F,
                80,
                80,
                "https://cdn.staticneo.com/w/pokemon/1/10/Alolan_Sandshrew.png"))
    }


}