package com.mathews.codetracker.modules.splash.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class SplashScreenPresenter
    @Inject constructor(private val view: SplashScreenView, private val model: SplashScreenModel) {

    private val compositeDisposables = CompositeDisposable()

    fun onCreate() {
        compositeDisposables.add(onSplashScreenTapped())
    }

    private fun onSplashScreenTapped() : Disposable {
        return view.splashScreenTapped().subscribe {
            model.navigateToSelectOption()
        }
    }

    fun onDestroy() {
        compositeDisposables.clear()
    }
}