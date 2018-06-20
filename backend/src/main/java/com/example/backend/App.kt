package com.example.backend

import android.app.Application

/**
 * Created by Titouche on 25-Apr-18.
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        RoomService.context = applicationContext
    }
}