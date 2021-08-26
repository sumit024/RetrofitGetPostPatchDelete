package com.app_devs.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class UserAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var userList= mutableListOf<User>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model=userList[position]
        if(holder is MyViewHolder)
        {
            holder.itemView.tv_name.text=model.name
            holder.itemView.tv_email.text=model.email
            holder.itemView.tv_status.text=model.status
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
    class MyViewHolder(view:View):RecyclerView.ViewHolder(view)

}