package com.bitas.retrofithp.api

import retrofit2.http.GET


interface Api {

    @GET("/api/characters/students")
    suspend fun getStudent():ArrayList<ApiData>

    @GET("/api/characters/staff")
    suspend fun getStaff():ArrayList<ApiData>
}