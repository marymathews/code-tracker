package com.mathews.codetracker.modules.viewSessionList.di

import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.modules.viewSessionList.mvp.*
import com.mathews.database_module.DatabaseClass
import dagger.Module
import dagger.Provides

@Module
class ViewSessionListModule(val activity: AppCompatActivity) {

    @Provides
    @ViewSessionListScope
    fun viewSessionListModel(databaseClass: DatabaseClass) : ViewSessionListModel {
        return ViewSessionListModel(activity, databaseClass)
    }

    @Provides
    @ViewSessionListScope
    fun viewSessionListPresenter(view: ViewSessionListView, model: ViewSessionListModel) : ViewSessionListPresenter {
        return ViewSessionListPresenter(view, model)
    }

    @Provides
    @ViewSessionListScope
    fun viewSessionListView(state: ViewSessionListViewState, adapter: ViewSessionListRecyclerAdapter) : ViewSessionListView {
        return ViewSessionListView(activity, state, adapter)
    }

    @Provides
    @ViewSessionListScope
    fun viewSessionListRecyclerAdapter() : ViewSessionListRecyclerAdapter {
        return ViewSessionListRecyclerAdapter(activity)
    }
}