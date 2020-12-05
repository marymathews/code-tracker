package com.mathews.codetracker.modules.addSessionDetails.di

import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.modules.addSessionDetails.mvp.AddSessionDetailsModel
import com.mathews.codetracker.modules.addSessionDetails.mvp.AddSessionDetailsPresenter
import com.mathews.codetracker.modules.addSessionDetails.mvp.AddSessionDetailsView
import com.mathews.database_module.DatabaseClass
import dagger.Module
import dagger.Provides

@Module
class AddSessionDetailsModule(val activity: AppCompatActivity) {

    @Provides
    @AddSessionDetailsScope
    fun addSessionDetailsPresenter(view : AddSessionDetailsView, model : AddSessionDetailsModel) : AddSessionDetailsPresenter {
        return AddSessionDetailsPresenter(view, model)
    }

    @Provides
    @AddSessionDetailsScope
    fun addSessionDetailsView() : AddSessionDetailsView {
        return AddSessionDetailsView(activity)
    }

    @Provides
    @AddSessionDetailsScope
    fun addSessionDetailsModel(database : DatabaseClass) : AddSessionDetailsModel {
        return AddSessionDetailsModel(activity, database)
    }
}