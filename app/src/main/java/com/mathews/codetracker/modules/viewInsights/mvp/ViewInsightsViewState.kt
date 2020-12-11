package com.mathews.codetracker.modules.viewInsights.mvp

import javax.inject.Inject

class ViewInsightsViewState
@Inject constructor() {
    var sites = ArrayList<String>()
    var levels = ArrayList<String>()
    var siteCountMap = HashMap<String, Long>()
    var levelCountMap = HashMap<String, Long>()
    var levelTimeMap = HashMap<String, Double>()
    var avgNumberOfSessions : Double = 0.0
    var totalNumberOfSessions : Long = 0L
}