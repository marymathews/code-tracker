package com.mathews.database_module.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mathews.database_module.entities.SessionEntity
@Dao
interface SessionDao {

    @Insert
    fun insert(sessionEntity : SessionEntity)

    @Query("SELECT * FROM sessions")
    fun getAllSessions() : List<SessionEntity>

    @Delete
    fun deleteSession(sessionEntity : SessionEntity)

    @Query("SELECT * FROM sessions where id = :sessionId")
    fun getSessionById(sessionId : Long) : SessionEntity

    @Query("SELECT DISTINCT level FROM sessions")
    fun getDistinctLevels() : List<String>

    @Query("SELECT COUNT(*) FROM sessions WHERE level = :sessionLevel")
    fun getCountOfEachLevel(sessionLevel : String) : Long

    @Query("SELECT AVG(time) FROM sessions WHERE level = :sessionLevel")
    fun getAverageTimeForEachLevel(sessionLevel: String) : Double

    @Query("SELECT DISTINCT site FROM sessions")
    fun getDistinctSites() : List<String>

    @Query("SELECT COUNT(*) FROM sessions WHERE site = :sessionSite")
    fun getCountOfEachSite(sessionSite : String) : Long

    @Query("SELECT COUNT(DISTINCT(date)) FROM sessions")
    fun getTotalNumberOfDates() : Long

    @Query("SELECT COUNT(*) FROM sessions")
    fun getTotalNumberOfSessions() : Long
}