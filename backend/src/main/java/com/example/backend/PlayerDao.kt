package com.example.backend

import android.arch.persistence.room.*

/**
 * Created by Titouche on 25-Apr-18.
 */
@Dao
interface PlayerDao {
    @Query("select * from Player")
    fun getPlayer():List<Player>
    @Query("select * from Player where first_name=:firstName and last_name=:lastName")
    fun getPlayersByName(firstName:String,lastName:String):List<Player>
    @Insert
    fun addPlayers (vararg player: Player)
    @Update
    fun updatePlayer(player: Player)

    @Delete
    fun deletePlayer(player: Player)

    @Delete
    fun deleteAllPlayers(player:List<Player>)

    @Query("select * from  Player natural join Team where team_name=:Name")
    fun getPlayersTeam (Name: String):List<Player>
}