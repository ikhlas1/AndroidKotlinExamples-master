package com.example.appservice

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Titouche on 09-May-18.
 */
@Entity(tableName = "team")
//    data class Team (var id_team:Int,var team_name:String,var continent:String) {
//
//    }
data class Team (
        @ColumnInfo(name = "team_name")
        var team_name:String,
        @ColumnInfo(name = "continent")
        var continent:String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_team")
    var id_team:Int?=null
}