package com.mathews.codetracker.app.di

import android.content.Context
import com.mathews.database_module.DatabaseClass
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class DatabaseModule {

    @Provides
    @ApplicationScope
    fun getDatabase(@ApplicationContext context: Context) : DatabaseClass {
        return DatabaseClass.getDatabase(context)
    }
}