package com.mathews.codetracker.modules.addSessionDetails.mvp

import javax.inject.Inject

class AddSessionDetailsPresenter
@Inject constructor(val view: AddSessionDetailsView, val model: AddSessionDetailsModel) {

    fun onBackPressed() {
        model.onBackPressed()
    }
}