package com.mathews.codetracker.modules.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mathews.codetracker.modules.splash.di.DaggerSplashComponent
import com.mathews.codetracker.modules.splash.di.SplashModule
import com.mathews.codetracker.modules.splash.mvp.SplashScreenPresenter
import com.mathews.codetracker.modules.splash.mvp.SplashScreenView
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject lateinit var presenter : SplashScreenPresenter

    @Inject lateinit var view : SplashScreenView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val component = DaggerSplashComponent.builder()
            .splashModule(SplashModule(this))
            .build()
        component.injectSplashActivity(this)

        setContentView(view)
        presenter.onCreate()
    }
}