package com.mathews.codetracker.modules.viewSessionList.mvp

import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class ViewSessionListPresenter
@Inject constructor(private val view: ViewSessionListView, private val model: ViewSessionListModel) {

    private val compositeDisposables = CompositeDisposable()
    private lateinit var scope: CoroutineScope

    fun onCreate(scope: CoroutineScope) {
        this.scope = scope
        view.initView()
        getSessionsFromDb()
    }

    private fun getSessionsFromDb() {
        scope.launch(Dispatchers.IO) {
            view.state.sessionsList = ArrayList(model.fetchSessions())
            displaySessions()
        }
    }

    private fun displaySessions() {
        scope.launch(Dispatchers.Main) {
            view.renderView()
        }
    }

    fun onDestroy() {
        cancelScope()
        compositeDisposables.clear()
    }

    fun onBackPressed() {
        cancelScope()
        model.onBackPressed()
    }

    private fun cancelScope() {
        try {
            scope.cancel()
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }
}