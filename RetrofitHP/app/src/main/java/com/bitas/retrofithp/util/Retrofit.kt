package com.bitas.retrofithp.util

import com.bitas.retrofithp.api.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

    companion object {

        var BASE_URL = "https://hp-api.herokuapp.com"

        fun create() : Api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build().create(Api::class.java)
    }
}