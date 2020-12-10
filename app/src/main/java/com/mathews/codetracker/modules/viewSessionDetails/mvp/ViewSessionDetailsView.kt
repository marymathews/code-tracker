package com.mathews.codetracker.modules.viewSessionDetails.mvp

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.snackbar.Snackbar
import com.jakewharton.rxbinding2.view.RxView
import com.mathews.codetracker.R
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_view_session_details.view.*
import javax.inject.Inject

@SuppressLint("ViewConstructor")
class ViewSessionDetailsView
@Inject constructor(val activity: AppCompatActivity, val state: ViewSessionDetailsViewState) : ConstraintLayout(activity) {

    init {
        View.inflate(context, R.layout.activity_view_session_details, this)
    }

    fun initView() {
        tv_title.text = state.session.title
        tv_site.text = state.session.site
        tv_date.text = state.session.date
        tv_time.text = String.format(activity.getString(R.string.time_taken), state.session.time)
        tv_level.text = state.session.level

        if(state.session.timeComplexity.isNullOrBlank()) {
            tv_time_complexity.visibility = GONE
        } else {
            tv_time_complexity.visibility = View.VISIBLE
            tv_time_complexity.text = String.format(activity.getString(R.string.time), state.session.timeComplexity)
        }

        if(state.session.spaceComplexity.isNullOrBlank()) {
            tv_space_complexity.visibility = GONE
        } else {
            tv_space_complexity.visibility = View.VISIBLE
            tv_space_complexity.text = String.format(activity.getString(R.string.space), state.session.spaceComplexity)
        }

        if(state.session.problemDescription.isNullOrBlank()) {
            tv_problem_desc.visibility = GONE
        } else {
            tv_problem_desc.visibility = View.VISIBLE
            tv_problem_desc.text = String.format(activity.getString(R.string.problem), state.session.problemDescription)
        }

        if(state.session.solutionDescription.isNullOrBlank()) {
            tv_solution_desc.visibility = GONE
        } else {
            tv_solution_desc.visibility = View.VISIBLE
            tv_solution_desc.text = String.format(activity.getString(R.string.solution), state.session.solutionDescription)
        }

        if(state.session.link.isNullOrBlank()) {
            tv_link.visibility = GONE
        } else {
            tv_link.visibility = View.VISIBLE
            tv_link.text = state.session.link
        }
    }

    fun onLinkClickedObservable() : Observable<Any> {
        return RxView.clicks(tv_link)
    }

    fun showError() {
        val snackbar = Snackbar.make(this, activity.getText(R.string.database_error), Snackbar.LENGTH_LONG)
        val text = snackbar.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text) as TextView
        text.typeface =  ResourcesCompat.getFont(context, R.font.sharp_sans_no1_medium)
        snackbar.show()
    }
}