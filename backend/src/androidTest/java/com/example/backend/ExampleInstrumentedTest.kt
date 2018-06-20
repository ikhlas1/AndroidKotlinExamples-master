package com.example.backend

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    var mDataBase:AppDatabase?=null

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("example.android.com.sqliteexampleroom", appContext.packageName)
    }

    @Before
    fun initDB() {
        mDataBase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry
                .getContext(),AppDatabase::class.java).build()
    }

    @After
    fun closeDb(){
        mDataBase?.close()
    }

    @Test
    fun insertAndGetUser(){
        val team = Team (1,"tttt","bbbbb")
        mDataBase?.getTeamDao()?.addTeams(team)
        assertEquals(mDataBase?.getTeamDao()?.getTeams()?.get(0),team)
    }


}