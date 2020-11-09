package com.mathews.codetracker.modules.addSessionDetails.mvp

import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.R
import com.mathews.database_module.DatabaseClass
import javax.inject.Inject

class AddSessionDetailsModel
@Inject constructor(val activity: AppCompatActivity) {

    fun onBackPressed() {
        activity.finish()
        activity.overridePendingTransition(R.anim.slide_out_new, R.anim.slide_in_old)
    }
}