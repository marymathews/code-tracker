package com.mathews.codetracker.modules.viewSessionList.mvp

import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.R
import com.mathews.database_module.DatabaseClass
import com.mathews.database_module.entities.SessionEntity
import java.lang.Exception
import javax.inject.Inject

class ViewSessionListModel
@Inject constructor(private val activity: AppCompatActivity, private val databaseClass: DatabaseClass) {

    fun onBackPressed() {
        activity.finish()
        activity.overridePendingTransition(R.anim.slide_out_new, R.anim.slide_in_old)
    }

    fun fetchSessions() : List<SessionEntity> {
        return try {
            databaseClass.sessionDao().getAllSessions()
        } catch (e : Exception) {
            ArrayList<SessionEntity>()
        }
    }
}