package com.mathews.codetracker.modules.viewInsights.mvp

import android.annotation.SuppressLint
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class ViewInsightsPresenter
@Inject constructor(private val view: ViewInsightsView, private val model: ViewInsightsModel) {

    private val compositeDisposables = CompositeDisposable()
    private lateinit var scope: CoroutineScope

    fun onCreate(scope : CoroutineScope) {
        this.scope = scope
        getListOfLevels()
        getListOfSites()
        getAverageCountOfProblems()
    }

    private fun getListOfLevels() {
        scope.launch(Dispatchers.IO) {
            view.state.levels = ArrayList(model.getDistinctLevels())
            populateLevelMaps()
        }
    }

    private fun getListOfSites() {
        scope.launch(Dispatchers.IO) {
            view.state.sites = ArrayList(model.getDistinctSites())
            populateSiteCountMap()
        }
    }

    @SuppressLint("DefaultLocale")
    private fun populateSiteCountMap() {
        scope.launch(Dispatchers.IO) {
            for(site in view.state.sites) {
                view.state.siteCountMap[site.toLowerCase(Locale.getDefault()).capitalize()] = model.getCountOfEachSite(site)
            }
            renderSiteCount()
        }
    }

    private fun renderSiteCount() {
        scope.launch(Dispatchers.Main) {
            view.renderSiteCount()
        }
    }

    @SuppressLint("DefaultLocale")
    private fun populateLevelMaps() {
        scope.launch(Dispatchers.IO) {
            for(level in view.state.levels) {
                val levelString = level.toLowerCase(Locale.getDefault()).capitalize()
                view.state.levelCountMap[levelString] = model.getCountOfEachLevel(level)
                view.state.levelTimeMap[levelString] = model.getAverageTimeForEachLevel(level)
            }
            renderLevelCount()
            renderLevelTime()
        }
    }

    private fun renderLevelCount() {
        scope.launch(Dispatchers.Main) {
            view.renderLevelCount()
        }
    }

    private fun renderLevelTime() {
        scope.launch(Dispatchers.Main) {
            view.renderLevelTime()
        }
    }

        private fun getAverageCountOfProblems()  {
        scope.launch(Dispatchers.IO) {
            view.state.totalNumberOfSessions = model.getTotalNumberOfSessions()
            if(view.state.totalNumberOfSessions != 0L)
                view.state.avgNumberOfSessions = view.state.totalNumberOfSessions / model.getTotalNumberOfDates().toDouble()
            renderTotalAndAverage()
        }
    }

    private fun renderTotalAndAverage() {
        scope.launch(Dispatchers.Main) {
            view.renderTotalAndAverage()
        }
    }

    fun onBackPressed() {
        cancelScope()
        model.onBackPressed()
    }

    fun onDestroy() {
        cancelScope()
        compositeDisposables.clear()
    }

    private fun cancelScope() {
        try {
            scope.cancel()
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }
}