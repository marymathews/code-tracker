package com.mathews.codetracker.modules.viewSessionList.mvp

import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.R
import com.mathews.codetracker.modules.viewSessionDetails.ViewSessionDetailsActivity
import com.mathews.database_module.DatabaseClass
import com.mathews.database_module.entities.SessionEntity
import java.lang.Exception
import javax.inject.Inject

class ViewSessionListModel
@Inject constructor(val activity: AppCompatActivity, private val databaseClass: DatabaseClass) {

    fun onBackPressed() {
        activity.finish()
        activity.overridePendingTransition(R.anim.slide_out_new, R.anim.slide_in_old)
    }

    fun fetchSessions() : List<SessionEntity> {
        return try {
            databaseClass.sessionDao().getAllSessions()
        } catch (e : Exception) {
            e.printStackTrace()
            ArrayList<SessionEntity>()
        }
    }

    fun deleteSession(sessionEntity : SessionEntity) : Boolean {
        try {
            databaseClass.sessionDao().deleteSession(sessionEntity)
        } catch (e : Exception) {
            e.printStackTrace()
            return false
        }
        return true
    }

    fun navigateToSessionDetailsScreen(sessionId : Long) {
        ViewSessionDetailsActivity.start(activity, sessionId)
    }
}