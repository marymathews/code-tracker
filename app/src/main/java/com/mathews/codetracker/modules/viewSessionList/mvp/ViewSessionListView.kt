package com.mathews.codetracker.modules.viewSessionList.mvp

import android.annotation.SuppressLint
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.mathews.codetracker.R
import javax.inject.Inject

@SuppressLint("ViewConstructor")
class ViewSessionListView
@Inject constructor(activity: AppCompatActivity, state: ViewSessionListViewState, adapter: ViewSessionListRecyclerAdapter)
    : ConstraintLayout(activity) {

    init {
        View.inflate(context, R.layout.activity_session_list, this)
    }
}