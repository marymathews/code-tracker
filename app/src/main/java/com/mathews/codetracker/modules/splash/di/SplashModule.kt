package com.mathews.codetracker.modules.splash.di

import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.modules.splash.mvp.SplashScreenModel
import com.mathews.codetracker.modules.splash.mvp.SplashScreenPresenter
import com.mathews.codetracker.modules.splash.mvp.SplashScreenView
import dagger.Module
import dagger.Provides

@Module
class SplashModule(private val activity : AppCompatActivity) {

    @Provides
    @SplashScope
    fun splashScreenPresenter(view : SplashScreenView, model: SplashScreenModel) : SplashScreenPresenter {
        return SplashScreenPresenter(view, model)
    }

    @Provides
    @SplashScope
    fun splashScreenView() : SplashScreenView {
        return SplashScreenView(activity)
    }

    @Provides
    @SplashScope
    fun splashScreenModel() : SplashScreenModel {
        return SplashScreenModel(activity)
    }
}