package com.mathews.codetracker.modules.viewSessionDetails.di

import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.modules.viewSessionDetails.mvp.ViewSessionDetailsModel
import com.mathews.codetracker.modules.viewSessionDetails.mvp.ViewSessionDetailsPresenter
import com.mathews.codetracker.modules.viewSessionDetails.mvp.ViewSessionDetailsView
import com.mathews.codetracker.modules.viewSessionDetails.mvp.ViewSessionDetailsViewState
import com.mathews.database_module.DatabaseClass
import dagger.Module
import dagger.Provides

@Module
class ViewSessionDetailsModule(private val activity: AppCompatActivity) {

    @Provides
    @ViewSessionDetailsScope
    fun viewSessionDetailsPresenter(view: ViewSessionDetailsView, model: ViewSessionDetailsModel) : ViewSessionDetailsPresenter {
        return ViewSessionDetailsPresenter(view, model)
    }

    @Provides
    @ViewSessionDetailsScope
    fun viewSessionDetailsModel(database: DatabaseClass) : ViewSessionDetailsModel {
        return ViewSessionDetailsModel(activity, database)
    }

    @Provides
    @ViewSessionDetailsScope
    fun viewSessionDetailsView(state : ViewSessionDetailsViewState) : ViewSessionDetailsView {
        return ViewSessionDetailsView(activity, state)
    }
}