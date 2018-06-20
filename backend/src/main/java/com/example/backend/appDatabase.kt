package com.example.backend

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by Titouche on 25-Apr-18.
 */
@Database(entities = arrayOf(Team::class, Player::class),version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getTeamDao():TeamDao
    abstract fun getPlayerDao():PlayerDao

}
