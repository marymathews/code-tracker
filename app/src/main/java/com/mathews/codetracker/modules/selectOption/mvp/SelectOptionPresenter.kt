package com.mathews.codetracker.modules.selectOption.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class SelectOptionPresenter
@Inject constructor(val view: SelectOptionView, val model: SelectOptionModel) {

    private val compositeDisposables = CompositeDisposable()

    fun onCreate() {
        compositeDisposables.add(getEnterDetailsClickedObservable())
        compositeDisposables.add(getViewDetailsClickedObservable())
    }

    private fun getEnterDetailsClickedObservable(): Disposable {
        return view.getEnterDetailsClickedObservable().subscribe {
            model.navigateToEnterSessionDetailsScreen()
        }
    }

    private fun getViewDetailsClickedObservable() : Disposable {
        return view.getViewDetailsClickedObservable().subscribe {
            model.navigateToViewSessionListScreen()
        }
    }

    fun onDestroy() {
        compositeDisposables.clear()
    }
}