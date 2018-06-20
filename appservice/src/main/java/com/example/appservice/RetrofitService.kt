package com.example.appservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Titouche on 09-May-18.
 */
object RetrofitService {

    val endpoint:Endpoint by lazy {
        Retrofit.Builder().baseUrl("http://192.168.0.153:8082/").
                addConverterFactory(GsonConverterFactory.create()).build().create(Endpoint::class.java)

    }
}