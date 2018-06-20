package com.example.backend

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.ForeignKey

/**
 * Created by Titouche on 25-Apr-18.
 */
@Entity( foreignKeys = arrayOf(ForeignKey(entity = Team ::class,
        parentColumns = arrayOf("id_team"),
        childColumns = arrayOf("id_team"),
        onDelete = ForeignKey.CASCADE)))
data class Player(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id_player")
        var id_player:Int,
        @ColumnInfo(name = "first_name")
        var first_name:String,
        @ColumnInfo(name = "last_name")
        var last_name:String,
        @ColumnInfo(name = "age")
        var age:String,
        @ColumnInfo(name = "height")
        var height:String,
        @ColumnInfo(name = "id_team")
        var id_team:Int
)