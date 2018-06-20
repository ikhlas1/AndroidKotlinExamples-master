package com.example.backend

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Titouche on 25-Apr-18.
 */
@Entity(tableName = "team")
data class Team(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id_team")
        var id_team:Int,
        @ColumnInfo(name = "team_name")
        var team_name:String,
        @ColumnInfo(name = "continent")
        var continent:String
)