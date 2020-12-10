package com.mathews.codetracker.modules.viewSessionDetails.mvp

import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.R
import com.mathews.codetracker.modules.addSessionDetails.AddSessionDetailsActivity
import com.mathews.codetracker.modules.viewSessionList.ViewSessionListActivity
import com.mathews.database_module.DatabaseClass
import com.mathews.database_module.entities.SessionEntity
import java.lang.Exception
import javax.inject.Inject

class ViewSessionDetailsModel
@Inject constructor(val activity: AppCompatActivity, private val database: DatabaseClass) {

    fun onBackPressed() {
        activity.finish()
        activity.overridePendingTransition(R.anim.slide_out_new, R.anim.slide_in_old)
    }

    fun fetchSessionFromDb(sessionId : Long) : SessionEntity? {
        return try {
            database.sessionDao().getSessionById(sessionId)
        } catch (e : Exception) {
            null
        }
    }
}