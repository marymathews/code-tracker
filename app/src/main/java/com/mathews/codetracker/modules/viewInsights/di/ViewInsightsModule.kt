package com.mathews.codetracker.modules.viewInsights.di

import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.modules.viewInsights.mvp.*
import com.mathews.database_module.DatabaseClass
import dagger.Module
import dagger.Provides

@Module
class ViewInsightsModule(val activity: AppCompatActivity) {

    @Provides
    @ViewInsightsScope
    fun viewInsightsModel(databaseClass: DatabaseClass) : ViewInsightsModel {
        return ViewInsightsModel(activity, databaseClass)
    }

    @Provides
    @ViewInsightsScope
    fun viewInsightsPresenter(view: ViewInsightsView, model: ViewInsightsModel) : ViewInsightsPresenter {
        return ViewInsightsPresenter(view, model)
    }

    @Provides
    @ViewInsightsScope
    fun viewInsightsView(state: ViewInsightsViewState) : ViewInsightsView {
        return ViewInsightsView(activity, state)
    }
}