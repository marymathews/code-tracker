package com.mathews.codetracker.modules.splash.di

import com.mathews.codetracker.app.di.ApplicationComponent
import com.mathews.codetracker.modules.splash.SplashActivity
import dagger.Component

@SplashScope
@Component(modules = [SplashModule::class])
interface SplashComponent {
    fun injectSplashActivity(activity: SplashActivity)
}