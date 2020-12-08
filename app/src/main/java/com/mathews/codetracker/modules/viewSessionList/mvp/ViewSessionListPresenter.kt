package com.mathews.codetracker.modules.viewSessionList.mvp

import javax.inject.Inject

class ViewSessionListPresenter
@Inject constructor(private val view: ViewSessionListView, private val model: ViewSessionListModel) {

    fun onBackPressed() {
        model.onBackPressed()
    }
}