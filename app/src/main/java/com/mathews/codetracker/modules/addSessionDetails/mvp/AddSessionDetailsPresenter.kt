package com.mathews.codetracker.modules.addSessionDetails.mvp

import com.mathews.codetracker.app.AppConstants
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.joda.time.format.DateTimeFormat
import java.lang.Exception
import javax.inject.Inject

class AddSessionDetailsPresenter
@Inject constructor(val view: AddSessionDetailsView, val model: AddSessionDetailsModel) {

    private val compositeDisposables = CompositeDisposable()
    private val dateFormatter = DateTimeFormat.forPattern(AppConstants.dateFormat)

    fun onCreate() {
        compositeDisposables.add(onSaveClickedObservable())
    }

    fun onBackPressed() {
        model.onBackPressed()
    }

    private fun onSaveClickedObservable() : Disposable {
        return view.onSaveClickedObservable().subscribe {
            view.saveDataIntoViewState()
            validateData()
        }
    }

    private fun validateData() {
        if(!view.state.isDataProcessingInProgress) {
            view.state.isDataProcessingInProgress = true
            if (validateRequiredField(view.state.problemTitle)
                && validateRequiredField(view.state.site)
                && validateRequiredField(view.state.level)
                && validateDateTime(view.state.date)
                && validateTime(view.state.time)
            ) {
                //todo save data into db then set isDataProcessingInProgress to false
            } else {
                view.state.isDataProcessingInProgress = false
                view.showDataValidationError()
            }
        }
    }

    private fun validateRequiredField(fieldData : String?) : Boolean {
        return !fieldData.isNullOrBlank()
    }

    private fun validateDateTime(fieldData: String?) : Boolean {
        try {
            dateFormatter.parseDateTime(fieldData)
        } catch (e : Exception) {
            return false
        }
        return true
    }

    private fun validateTime(fieldData: String?) : Boolean {
        var time : Int = 0
        try {
            time = fieldData?.toInt() ?: 0
        } catch (e : Exception) {
            e.printStackTrace()
        }
        return time != 0
    }
}