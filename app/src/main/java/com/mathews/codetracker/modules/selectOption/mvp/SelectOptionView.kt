package com.mathews.codetracker.modules.selectOption.mvp

import android.annotation.SuppressLint
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.mathews.codetracker.R
import javax.inject.Inject

@SuppressLint("ViewConstructor")
class SelectOptionView
@Inject constructor(val activity: AppCompatActivity) : ConstraintLayout(activity) {

    init {
        View.inflate(context, R.layout.activity_select_option, this)
    }
}