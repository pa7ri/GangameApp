package com.example.gangame.deals

import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.commons.BaseListFragment
import com.example.commons.DataBindingRecyclerAdapter
import com.example.gangame.BR
import com.example.gangame.R
import com.example.gangame.data.GangameDataSource
import com.example.gangame.Deal


class DealsFragment: BaseListFragment() {
    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<Deal>(BR.deal, R.layout.item_deal)
    }

    override fun updateItems() {
       GangameDataSource
               .getDeals()
               .subscribe({ list ->
                   replaceItems(list)
               },{error ->
                    showError(error)
               })
    }

    private fun showError(error: Throwable) {
        Log.e("Error update data", error.message)
    }

    private fun replaceItems(list : List<Deal>){
        with(listAdapter as DataBindingRecyclerAdapter<Deal>){
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }
    }
}