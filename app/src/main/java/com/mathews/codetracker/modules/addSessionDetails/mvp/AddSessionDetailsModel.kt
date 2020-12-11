package com.mathews.codetracker.modules.addSessionDetails.mvp

import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.R
import com.mathews.database_module.DatabaseClass
import com.mathews.database_module.entities.SessionEntity
import java.lang.Exception
import javax.inject.Inject

class AddSessionDetailsModel
@Inject constructor(val activity: AppCompatActivity, private val database: DatabaseClass) {

    fun onBackPressed() {
        activity.finish()
        activity.overridePendingTransition(R.anim.slide_out_new, R.anim.slide_in_old)
    }

    suspend fun insertEntity(session : SessionEntity) : Boolean {
        try {
            database.sessionDao().insert(session)
        } catch (e : Exception) {
            e.printStackTrace()
            return false
        }
        return true
    }
}