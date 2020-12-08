package com.mathews.database_module.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mathews.database_module.entities.SessionEntity
@Dao
interface SessionDao {

    @Insert
    fun insert(sessionEntity : SessionEntity)

    @Query("SELECT * FROM sessions")
    fun getAllSessions() : List<SessionEntity>
}