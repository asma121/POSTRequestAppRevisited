package com.example.postrequestapprevisited

import retrofit2.Call
import retrofit2.http.*

interface APIInterface {
    @Headers("Content-Type: application/json")
    @GET("/test/")
    fun getUserDetails(): Call<List<UserDetails.Datum>>

    @Headers("Content-Type: application/json")
    @POST("/test/")
    fun addUserDetails(@Body userdata:UserDetails.Datum): Call<UserDetails.Datum>

    @Headers("Content-Type: application/json")
    @PUT("/test/{id}")
    fun upDateUserDetails(@Path("id") id:Int,@Body userdata: UserDetails.Datum): Call<UserDetails.Datum>

    @Headers("Content-Type: application/json")
    @DELETE("/test/{id}")
    fun delUserDetails(@Path("id") id: Int): Call<Void>



}