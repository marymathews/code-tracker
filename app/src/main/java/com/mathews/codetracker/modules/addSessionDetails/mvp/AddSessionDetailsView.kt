package com.mathews.codetracker.modules.addSessionDetails.mvp

import android.annotation.SuppressLint
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.mathews.codetracker.R
import javax.inject.Inject

@SuppressLint("ViewConstructor")
class AddSessionDetailsView
@Inject constructor(activity: AppCompatActivity) : ConstraintLayout(activity) {

    init {
        View.inflate(context, R.layout.activity_add_session_details, this)
    }
}