package com.mathews.database_module.dao

import androidx.room.Dao
import androidx.room.Insert
import com.mathews.database_module.entities.SessionEntity
@Dao
interface SessionDao {

    @Insert
    fun insert(sessionEntity : SessionEntity)
}