package com.mathews.codetracker.app.di

import com.mathews.database_module.DatabaseClass
import dagger.Component

@ApplicationScope
@Component(modules = [ContextModule::class, DatabaseModule::class])
interface ApplicationComponent {

    fun getDatabase() : DatabaseClass
}