package com.example.appservice

import android.app.Application

/**
 * Created by Titouche on 23-May-18.
 */
class App :Application(){
    override fun onCreate() {
        super.onCreate()
        RoomService.context = applicationContext
    }
}