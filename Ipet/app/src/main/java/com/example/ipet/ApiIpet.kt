package com.example.ipet

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiIpet {
    companion object {
        var BASE_URL = "http://34.193.7.207/"
        fun criar() : ApiIpet {
            var retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiIpet::class.java)
        }
    }
}