package com.app_devs.retrofit

import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    //https://gorest.co.in/public-api/users
    @GET("users")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun getUsersList(): Call<UserList>

    //https://gorest.co.in/public-api/users?name=a
    @GET("users")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun searchUsers(@Query("name") searchText: String): Call<UserList>


    //https://gorest.co.in/public-api/users/121
    @GET("users/{user_id}")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun getUser(@Path("user_id") user_id: String): Call<UserResponse>


    @POST("users")
    @Headers("Accept:application/json", "Content-Type:application/json",
        "Authorization: Bearer c109252632e2c922d2e99d846007767bf1e828e6e311d738eb4ab89f5b43f8ea")
    fun createUser(@Body params: User): Call<UserResponse>

    @PATCH("users/{user_id}")
    @Headers("Accept:application/json", "Content-Type:application/json",
        "Authorization: Bearer c109252632e2c922d2e99d846007767bf1e828e6e311d738eb4ab89f5b43f8ea")
    fun updateUser(@Path("user_id") user_id: String, @Body params: User): Call<UserResponse>

    @DELETE("users/{user_id}")
    @Headers("Accept:application/json", "Content-Type:application/json",
        "Authorization: Bearer c109252632e2c922d2e99d846007767bf1e828e6e311d738eb4ab89f5b43f8ea")
    fun deleteUser(@Path("user_id") user_id: String): Call<UserResponse>


}