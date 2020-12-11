package com.mathews.codetracker.modules.viewSessionDetails.mvp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.R
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
            e.printStackTrace()
            null
        }
    }

    fun openLink(link : String) : Boolean {
        try {
            val url: Uri = Uri.parse(link)
            val intent = Intent(Intent.ACTION_VIEW, url)
            if (intent.resolveActivity(activity.packageManager) != null)
                activity.startActivity(intent)
            else
                return false
        } catch (e : Exception) {
            e.printStackTrace()
            return false
        }
        return true
    }
}