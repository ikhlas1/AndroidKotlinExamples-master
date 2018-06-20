package com.example.appservice

import android.arch.persistence.room.*

/**
 * Created by Titouche on 23-May-18.
 */
@Dao
interface TeamDao {
    @Query("select * from Team")
    fun getTeams():List<Team>
    @Query("select * from Team where team_name=:teamname ")
    fun getTeamsByName(teamname:String):List<Team>
    @Insert
    fun addTeams (vararg team:Team)
    @Update
    fun updateTeam(team: Team)

    @Delete
    fun deleteTeam(team: Team)

    @Delete
    fun deleteAllTeams(team:List<Team>)
}