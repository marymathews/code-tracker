package com.mathews.codetracker.modules.selectOption.mvp

import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.modules.addSessionDetails.AddSessionDetailsActivity
import com.mathews.codetracker.modules.viewInsights.ViewInsightsActivity
import com.mathews.codetracker.modules.viewSessionList.ViewSessionListActivity
import javax.inject.Inject

class SelectOptionModel
@Inject constructor(val activity: AppCompatActivity) {

    fun navigateToEnterSessionDetailsScreen() {
        AddSessionDetailsActivity.start(activity)
    }

    fun navigateToViewSessionListScreen() {
        ViewSessionListActivity.start(activity)
    }

    fun navigateToViewInsightsScreen() {
        ViewInsightsActivity.start(activity)
    }
}