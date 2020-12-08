package com.mathews.codetracker.modules.selectOption.mvp

import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.modules.addSessionDetails.AddSessionDetailsActivity
import com.mathews.codetracker.modules.viewSessionList.ViewSessionListActivity
import com.mathews.database_module.DatabaseClass
import javax.inject.Inject

class SelectOptionModel
@Inject constructor(val activity: AppCompatActivity) {

    fun navigateToEnterSessionDetailsScreen() {
        AddSessionDetailsActivity.start(activity)
    }

    fun navigateToViewSessionListScreen() {
        ViewSessionListActivity.start(activity)
    }
}