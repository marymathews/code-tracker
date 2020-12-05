package com.mathews.database_module

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.mathews.database_module.dao.SessionDao
import com.mathews.database_module.entities.SessionEntity

@Database(entities = [SessionEntity::class], version = 1)
abstract class DatabaseClass : RoomDatabase() {

    abstract fun sessionDao() : SessionDao

    companion object {
        private val sLock = Any()
        private lateinit var INSTANCE : DatabaseClass

        fun getDatabase(context: Context) : DatabaseClass {
            synchronized(sLock) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseClass::class.java, "app-db.db"
                    ).build()
                }
                return INSTANCE
            }
        }
    }

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }
}