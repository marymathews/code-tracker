package com.mathews.codetracker.modules.viewInsights.mvp

import android.annotation.SuppressLint
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.jakewharton.rxbinding2.view.RxView
import com.mathews.codetracker.R
import io.reactivex.Observable
import javax.inject.Inject

@SuppressLint("ViewConstructor")
class ViewInsightsView
@Inject constructor(private val activity: AppCompatActivity, val state: ViewInsightsViewState)
    : ConstraintLayout(activity) {

    init {
        View.inflate(context, R.layout.activity_session_list, this)
    }
}