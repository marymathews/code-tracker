package com.mathews.codetracker.modules.viewSessionDetails.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class ViewSessionDetailsPresenter
@Inject constructor(val view: ViewSessionDetailsView, val model: ViewSessionDetailsModel) {

    private val compositeDisposables = CompositeDisposable()
    private lateinit var scope : CoroutineScope

    fun onCreate(scope : CoroutineScope, sessionId : Long) {
        compositeDisposables.add(onLinkClickedObservable())
        this.scope = scope
        view.state.sessionId = sessionId
        fetchSession()
    }

    private fun fetchSession() {
        scope.launch(Dispatchers.IO) {
            val session = model.fetchSessionFromDb(view.state.sessionId)
            if (session != null) {
                view.state.session = session
                displayDetails()
            } else {
                showError()
            }
        }
    }

    private fun displayDetails() {
        scope.launch(Dispatchers.Main) {
            view.initView()
        }
    }

    private fun showError() {
        scope.launch(Dispatchers.Main) {
            view.showError()
        }
    }

    private fun onLinkClickedObservable() : Disposable {
        return view.onLinkClickedObservable().subscribe {
            if(view.state.session.link?.let { it1 -> model.openLink(it1) } == false) {
                view.showError()
            }
        }
    }

    fun onDestroy() {
        compositeDisposables.clear()
        cancelScope()
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