package com.mathews.database_module

import android.content.Context
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

abstract class DatabaseClass : RoomDatabase() {

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