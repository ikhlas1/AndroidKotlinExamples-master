package com.example.appservice

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Titouche on 09-May-18.
 */
interface Endpoint {

    @GET("getteams")
    fun getTeam(): Call<List<Team>>
    @POST("addTeam")
    fun addTeam(@Body team: Team):Call<String>
}