package com.mathews.codetracker.modules.viewSessionList.mvp

import android.annotation.SuppressLint
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mathews.codetracker.R
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_session_list.view.*
import javax.inject.Inject

@SuppressLint("ViewConstructor")
class ViewSessionListView
@Inject constructor(private val activity: AppCompatActivity, val state: ViewSessionListViewState, private val adapter: ViewSessionListRecyclerAdapter)
    : ConstraintLayout(activity) {

    init {
        View.inflate(context, R.layout.activity_session_list, this)
    }

    fun initView() {
        rv_sessions.layoutManager = LinearLayoutManager(context)
        rv_sessions.adapter = adapter
    }

    fun renderView() {
        if(state.sessionsList.isEmpty()) {
            tv_no_sessions.visibility = View.VISIBLE
            rv_sessions.visibility = GONE
        } else {
            tv_no_sessions.visibility = GONE
            rv_sessions.visibility = View.VISIBLE
            adapter.setData(state.sessionsList)
        }
    }

    fun onDeleteClickedObservable() : Observable<Int> {
        return adapter.deleteClickedSubject
    }
}