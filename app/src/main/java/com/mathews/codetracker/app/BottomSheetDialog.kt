package com.mathews.codetracker.app

import android.content.Context
import com.google.android.material.bottomsheet.BottomSheetDialog
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

class BottomSheetDialog(context: Context) : BottomSheetDialog(context) {

    private val compositeDisposables = CompositeDisposable()

    fun setOnDismissListener(observable: Observable<Any>) {
        compositeDisposables.add(
            observable.subscribe {
                dismiss()
                compositeDisposables.clear()
            }
        )
    }
}