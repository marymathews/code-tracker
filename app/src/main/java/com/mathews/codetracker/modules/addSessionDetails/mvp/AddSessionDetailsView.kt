package com.mathews.codetracker.modules.addSessionDetails.mvp

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
import kotlinx.android.synthetic.main.activity_add_session_details.view.*
import javax.inject.Inject

@SuppressLint("ViewConstructor")
class AddSessionDetailsView
@Inject constructor(private val activity: AppCompatActivity, val state: AddSessionDetailsViewState) : ConstraintLayout(activity) {

    init {
        View.inflate(context, R.layout.activity_add_session_details, this)
    }

    fun onSaveClickedObservable() : Observable<Any> {
        return RxView.clicks(btn_save)
    }

    fun saveDataIntoViewState() {
        state.problemTitle = et_problem_title.text.toString()
        state.problemDescription = et_problem_desc.text.toString()
        state.site = et_problem_site.text.toString()
        state.link = et_problem_link.text.toString()
        state.level = et_problem_level.text.toString()
        state.solutionDescription = et_solution_desc.text.toString()
        state.timeComplexity = et_solution_time_complexity.text.toString()
        state.spaceComplexity = et_solution_space_complexity.text.toString()
        state.date = et_solution_date.text.toString()
        state.time = et_solution_time.text.toString()
    }

    fun showDataValidationError() {
        val snackbar = Snackbar.make(this, activity.getText(R.string.data_validation_error), Snackbar.LENGTH_LONG)
        val text = snackbar.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text) as TextView
        text.typeface =  ResourcesCompat.getFont(context, R.font.sharp_sans_no1_medium)
        snackbar.show()
    }

    fun showSuccessOrFailure(isSuccess : Boolean) {
        grp_session_details_form.visibility = View.GONE
        if(isSuccess) {
            tv_final_message.text = activity.getString(R.string.success_data_saved)
            tv_final_message.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icn_success, 0,0)
        } else {
            tv_final_message.text = activity.getString(R.string.failure_data_saved)
            tv_final_message.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.icn_failure, 0,0)
        }
        tv_final_message.visibility = View.VISIBLE
    }
}