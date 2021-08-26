package com.app_devs.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var recyclerViewAdapter: UserAdapter
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initViewModel()
        searchUser()

    }

    private fun searchUser()
    {
        search_btn.setOnClickListener {
            if(!TextUtils.isEmpty(et_name_search.text.toString())){
                viewModel.searchUser(et_name_search.text.toString())
            }else{
                viewModel.getUsersList()
            }
        }
    }

    private fun initRecyclerView()
    {
        users_rv.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            val decoration=DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewAdapter= UserAdapter()
            adapter=recyclerViewAdapter

        }
    }

    fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getUserListObservable().observe(this, Observer<UserList> {
            if(it == null) {
                Toast.makeText(this@MainActivity, "no result found...", Toast.LENGTH_LONG).show()
            } else {
                recyclerViewAdapter.userList = it.data.toMutableList()
                recyclerViewAdapter.notifyDataSetChanged()
            }
        })
        viewModel.getUsersList()
    }
}