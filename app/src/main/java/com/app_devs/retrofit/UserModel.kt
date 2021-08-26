package com.app_devs.retrofit

data class UserModel(
    val id:Int?,
    val name:String?,
    val email:String?,
    val gender:String?,
    val status:String?,
)
data class UserList(val list:List<UserModel>)
data class UserResponse(val code:Int?,val meta:String?,val data:UserModel?)
