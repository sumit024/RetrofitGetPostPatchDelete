package com.app_devs.retrofit.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app_devs.retrofit.UserList
import com.app_devs.retrofit.retro.RetrofitInstance
import com.app_devs.retrofit.retro.RetrofitService
import retrofit2.Call
import retrofit2.Response

class MainActivityViewModel:ViewModel() {

    var recyclerListData: MutableLiveData<UserList> = MutableLiveData()

    fun getUserListObservable():MutableLiveData<UserList>{
        return recyclerListData
    }

    fun getUsersList() {

        val retroInstance: RetrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        val call = retroInstance.getUsersList()
        call.enqueue(object : retrofit2.Callback<UserList>{
            override fun onFailure(call: Call<UserList>, t: Throwable) {
                recyclerListData.postValue(null)
            }

            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                if(response.isSuccessful) {
                    recyclerListData.postValue(response.body())
                } else {
                    recyclerListData.postValue(null)
                }
            }
        })
    }

    fun searchUser(searchText: String) {

        val retroInstance = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        val call = retroInstance.searchUsers(searchText)
        call.enqueue(object : retrofit2.Callback<UserList>{
            override fun onFailure(call: Call<UserList>, t: Throwable) {
                recyclerListData.postValue(null)
            }

            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                if(response.isSuccessful) {
                    recyclerListData.postValue(response.body())
                } else {
                    recyclerListData.postValue(null)
                }
            }
        })
    }
}