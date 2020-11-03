package com.mathews.codetracker.modules.selectOption.mvp

import android.annotation.SuppressLint
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.jakewharton.rxbinding2.view.RxView
import com.mathews.codetracker.R
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_select_option.view.*
import javax.inject.Inject

@SuppressLint("ViewConstructor")
class SelectOptionView
@Inject constructor(val activity: AppCompatActivity) : ConstraintLayout(activity) {

    init {
        View.inflate(context, R.layout.activity_select_option, this)
    }

    fun getEnterDetailsClickedObservable() : Observable<Any> {
        return RxView.clicks(btn_enter_details)
    }
}