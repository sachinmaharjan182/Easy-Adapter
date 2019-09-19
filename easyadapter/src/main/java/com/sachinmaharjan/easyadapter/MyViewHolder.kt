package com.sachinmaharjan.easyadapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.sachinmaharjan.easyadapter.BR

class MyViewHolder<T>(val binding: ViewDataBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(obj : T){
        binding.setVariable(BR.obj,obj)
        binding.executePendingBindings()
    }
}