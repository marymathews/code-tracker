package com.mathews.codetracker.app.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(private val context: Context) {

    @Provides
    @ApplicationContext
    @ApplicationScope
    fun applicationContext() : Context {
        return context
    }
}