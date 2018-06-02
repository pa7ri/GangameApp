package com.example.commons

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class DataBindingRecyclerAdapter<MODEL>(private val itemVariableId: Int, private val itemLayoutResId : Int) : RecyclerView.Adapter<DataBindingViewHolder<MODEL>>() {
    val items : MutableList<MODEL> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<MODEL> {
        val binding : ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                itemLayoutResId,
                parent,
                false)
        return com.example.commons.DataBindingViewHolder(itemVariableId, binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder<MODEL>, position: Int) {
        val item = items[position]
        holder.bindItem(item)
    }

}