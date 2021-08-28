package com.app_devs.retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app_devs.retrofit.R
import com.app_devs.retrofit.User
import kotlinx.android.synthetic.main.item_row.view.*

class UserAdapter(private val clickListener: OnItemClickListener): RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    var userList = mutableListOf<User>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return MyViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position])
        holder.itemView.setOnClickListener {
            clickListener.onItemEditClick(userList[position])
        }
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textViewName = view.tv_name
        val textViewEmail = view.tv_email
        val textViewStats = view.tv_status

        fun bind(data : User) {
            textViewName.text = data.name
            textViewEmail.text = data.email
            textViewStats.text = data.status
        }
    }

    interface OnItemClickListener {
        fun onItemEditClick(user : User)
    }
}