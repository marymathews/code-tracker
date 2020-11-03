package com.mathews.codetracker.modules.selectOption.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class SelectOptionPresenter
@Inject constructor(val view: SelectOptionView, val model: SelectOptionModel) {

    fun onCreate() {
        val compositeDisposables = CompositeDisposable()

        compositeDisposables.add(getEnterDetailsClickedObservable())
    }

    private fun getEnterDetailsClickedObservable(): Disposable {
        return view.getEnterDetailsClickedObservable().subscribe {
            model.navigateToEnterSessionDetailsScreen()
        }
    }
}