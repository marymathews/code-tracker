package com.mathews.codetracker.app

import android.app.Application
import com.mathews.codetracker.app.di.ApplicationComponent
import com.mathews.codetracker.app.di.ContextModule
import com.mathews.codetracker.app.di.DaggerApplicationComponent

class MainApplication : Application() {

    companion object {
        lateinit var instance : MainApplication
    }

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerApplicationComponent.builder()
            .contextModule(ContextModule(this.applicationContext))
            .build()
    }

    fun getApplicationComponent() : ApplicationComponent {
        return component
    }
}