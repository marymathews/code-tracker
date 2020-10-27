package com.mathews.codetracker.modules.splash.di

import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.modules.splash.mvp.SplashScreenPresenter
import com.mathews.codetracker.modules.splash.mvp.SplashScreenView
import dagger.Module
import dagger.Provides

@Module
class SplashModule(private val activity : AppCompatActivity) {

    @Provides
    @SplashScope
    fun splashScreenPresenter(view : SplashScreenView) : SplashScreenPresenter {
        return SplashScreenPresenter(view)
    }

    @Provides
    @SplashScope
    fun splashScreenView() : SplashScreenView {
        return SplashScreenView(activity)
    }
}