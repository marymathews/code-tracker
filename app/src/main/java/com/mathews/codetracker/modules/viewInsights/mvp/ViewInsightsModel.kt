package com.mathews.codetracker.modules.viewInsights.mvp

import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.R
import com.mathews.database_module.DatabaseClass
import com.mathews.database_module.entities.SessionEntity
import java.lang.Exception
import javax.inject.Inject

class ViewInsightsModel
@Inject constructor(val activity: AppCompatActivity, private val database: DatabaseClass) {

    fun onBackPressed() {
        activity.finish()
        activity.overridePendingTransition(R.anim.slide_out_new, R.anim.slide_in_old)
    }

    fun getDistinctLevels() : List<String> {
        return try {
            database.sessionDao().getDistinctLevels()
        } catch (e : Exception) {
            ArrayList<String>()
        }
    }

    fun getCountOfEachLevel(level : String) : Long {
        return try {
            database.sessionDao().getCountOfEachLevel(level)
        } catch (e : Exception) {
            0L
        }
    }

    fun getAverageTimeForEachLevel(level : String) : Double {
        return try {
            database.sessionDao().getAverageTimeForEachLevel(level)
        } catch (e : Exception) {
            return 0.0
        }
    }

    fun getDistinctSites() : List<String> {
        return try {
            database.sessionDao().getDistinctSites()
        } catch (e : Exception) {
            return ArrayList<String>()
        }
    }

    fun getCountOfEachSite(site : String) : Long {
        return try {
            database.sessionDao().getCountOfEachSite(site)
        } catch (e : Exception) {
            0L
        }
    }

    fun getTotalNumberOfDates() : Long {
        return try {
            database.sessionDao().getTotalNumberOfDates()
        } catch (e : Exception) {
            0L
        }
    }

    fun getTotalNumberOfSessions() : Long {
        return try {
            database.sessionDao().getTotalNumberOfSessions()
        } catch (e : Exception) {
            0L
        }
    }
}