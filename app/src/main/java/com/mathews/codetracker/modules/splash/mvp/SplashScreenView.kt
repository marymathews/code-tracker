package com.mathews.codetracker.modules.splash.mvp

import android.annotation.SuppressLint
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.jakewharton.rxbinding2.view.RxView
import com.mathews.codetracker.R
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_splash_screen.view.*
import javax.inject.Inject

@SuppressLint("ViewConstructor")
class SplashScreenView
    @Inject constructor(activity: AppCompatActivity) : ConstraintLayout(activity) {

    init {
        View.inflate(context, R.layout.activity_splash_screen, this)
    }

    fun splashScreenTapped() : Observable<Any> {
        return RxView.clicks(cl_splash)
    }
}