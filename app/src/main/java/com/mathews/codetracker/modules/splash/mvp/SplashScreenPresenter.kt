package com.mathews.codetracker.modules.splash.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class SplashScreenPresenter
    @Inject constructor(private val view: SplashScreenView) {

    fun onCreate() {
        val compositeDisposables = CompositeDisposable()
        compositeDisposables.add(onSplashScreenTapped())
    }

    private fun onSplashScreenTapped() : Disposable {
        return view.splashScreenTapped().subscribe {
        }
    }
}