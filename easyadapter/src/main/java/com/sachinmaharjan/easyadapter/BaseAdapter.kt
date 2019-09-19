package com.sachinmaharjan.easyadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.sachinmaharjan.easyadapter.BR

abstract class BaseAdapter<T,CALLBACK>(val context: Context,
                                       val callback:CALLBACK?)
    : RecyclerView.Adapter<MyViewHolder<T>>() {

    var dataList:ArrayList<T> = ArrayList()

    fun updateList(dataList: ArrayList<T>){
        this.dataList = dataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder<T> {
        val layoutInflater = LayoutInflater.from(context)
        val binding : ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, getLayoutId(), parent, false)
        if (callback!=null){
            binding.setVariable(BR.callback,callback)
        }
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder<T>, position: Int) {
        val obj=getItem(position)
        holder.bind(obj)
    }

    private fun getLayoutId(): Int {
        return setLayout()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    abstract fun setLayout(): Int

    fun getItem(postition:Int)=dataList.get(postition)

}