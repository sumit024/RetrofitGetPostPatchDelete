package com.app_devs.retrofit

import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    //https://gorest.co.in/public/v1/users
    @GET("users")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun getUsersList():Call<UserList>

    //https://gorest.co.in/public/v1/users?name=a
    @GET("users")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun searchUser(@Query("name") searchText:String):Call<UserList>

    //https://gorest.co.in/public/v1/users/121
    @GET("users/{user_id}")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun getUser(@Path("user_id") user_id:String):Call<UserList>


    @POST("users")
    @Headers("Accept:application/json", "Content-Type:application/json", "Authorization: Bearer ACCESS-TOKEN\" -XPOST ")
    fun createUser(@Body params:UserModel):Call<UserResponse>

    @PATCH("users/{user_id}")
    @Headers("Accept:application/json", "Content-Type:application/json", "Authorization: Bearer ACCESS-TOKEN\" -XPOST ")
    fun updateUser(@Path("user_id") user_id:String,@Body params:UserModel):Call<UserResponse>

    @DELETE("users/{user_id}")
    @Headers("Accept:application/json", "Content-Type:application/json", "Authorization: Bearer ACCESS-TOKEN\" -XPOST ")
    fun deleteUser(@Path("user_id") user_id:String):Call<UserResponse>


}