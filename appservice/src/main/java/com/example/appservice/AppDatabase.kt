package com.example.appservice

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by Titouche on 23-May-18.
 */
@Database(entities = arrayOf(Team::class),version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getTeamDao():TeamDao

}
