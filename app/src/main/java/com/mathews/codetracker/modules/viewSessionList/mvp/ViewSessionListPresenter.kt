package com.mathews.codetracker.modules.viewSessionList.mvp

import com.mathews.codetracker.R
import com.mathews.codetracker.app.AppConstants
import com.mathews.database_module.entities.SessionEntity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.joda.time.format.DateTimeFormat
import java.lang.Exception
import javax.inject.Inject

class ViewSessionListPresenter
@Inject constructor(private val view: ViewSessionListView, private val model: ViewSessionListModel) {

    private val compositeDisposables = CompositeDisposable()
    private lateinit var scope: CoroutineScope

    fun onCreate(scope: CoroutineScope) {
        compositeDisposables.add(onDeleteClickedObservable())
        compositeDisposables.add(onConfirmDeleteClickedObservable())
        compositeDisposables.add(onSessionCardClickedObservable())
        this.scope = scope
        view.initView()
        getSessionsFromDb()
    }

    private fun getSessionsFromDb() {
        scope.launch(Dispatchers.IO) {
            view.state.sessionsList = ArrayList(model.fetchSessions())
            sortSessionsByDate()
        }
    }

    private fun onDeleteClickedObservable() : Disposable {
        return view.onDeleteClickedObservable().subscribe {
            if (it >= 0 && it < view.state.sessionsList.size) {
                view.state.selectedSessionId = it
                view.showDialog(
                    String.format(
                        model.activity.getString(R.string.delete_session),
                        view.state.sessionsList[it].title
                    ),
                    model.activity.getString(R.string.delete),
                    R.drawable.icn_alert
                )
            }
        }
    }

    private fun onConfirmDeleteClickedObservable() : Disposable {
        return view.state.onConfirmDeletionClickedObservable.subscribe {
            deleteSession(view.state.selectedSessionId)
        }
    }

    private fun deleteSession(position : Int) {
        scope.launch(Dispatchers.IO) {
            model.deleteSession(view.state.sessionsList[position])
            getSessionsFromDb()
        }
    }

    private fun displaySessions() {
        scope.launch(Dispatchers.Main) {
            view.renderView()
        }
    }

    private fun sortSessionsByDate() {
        val formatter = DateTimeFormat.forPattern(AppConstants.dateFormat)
        for(session in view.state.sessionsList) {
            session.dateInDateFormat = formatter.parseDateTime(session.date)
        }
        view.state.sessionsList.sortByDescending { it.dateInDateFormat }
        displaySessions()
    }

    private fun onSessionCardClickedObservable() : Disposable {
        return view.onSessionCardClickedObservable().subscribe {
            if(it >= 0 && it < view.state.sessionsList.size) {
                model.navigateToSessionDetailsScreen(view.state.sessionsList[it].id)
            }
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