package com.app_devs.retrofit


import okhttp3.logging.HttpLoggingInterceptor

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {
    companion object{
        private const val baseUrl="https://gorest.co.in/public/v1/"
        fun getRetrofitInstance():Retrofit
        {
            val logging=HttpLoggingInterceptor()
            logging.level=HttpLoggingInterceptor.Level.BODY
            /*BODY – Logs request and response lines and their respective headers and bodies (if present).
             This is the only log level where we will get the response body data.*/
            val client=okhttp3.OkHttpClient.Builder()
            client.addInterceptor(logging)

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}