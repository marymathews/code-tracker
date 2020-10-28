package com.mathews.codetracker.app

import android.app.Application
import com.mathews.codetracker.app.di.ContextModule
import com.mathews.codetracker.app.di.DaggerApplicationComponent

class MainApplication : Application() {

    companion object {
        val instance = MainApplication()
    }

    override fun onCreate() {
        super.onCreate()

        val component = DaggerApplicationComponent.builder()
            .contextModule(ContextModule(this.applicationContext))
            .build()
    }

    fun getInstance() : MainApplication {
        return instance
    }
}