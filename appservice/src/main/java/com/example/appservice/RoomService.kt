package com.example.appservice

import android.arch.persistence.room.Room
import android.content.Context

/**
 * Created by Titouche on 23-May-18.
 */
object RoomService {

    lateinit var context: Context
    val appDatabase:AppDatabase by lazy {

        Room.databaseBuilder(context,AppDatabase::class.java,"dbuser").allowMainThreadQueries().build()
    }

}