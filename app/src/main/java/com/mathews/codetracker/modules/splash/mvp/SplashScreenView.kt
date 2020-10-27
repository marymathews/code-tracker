package com.mathews.codetracker.modules.splash.mvp

import android.annotation.SuppressLint
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.mathews.codetracker.R
import javax.inject.Inject

@SuppressLint("ViewConstructor")
class SplashScreenView
    @Inject constructor(activity: AppCompatActivity) : ConstraintLayout(activity) {

    init {
        View.inflate(context, R.layout.activity_splash_screen, this)
    }
}