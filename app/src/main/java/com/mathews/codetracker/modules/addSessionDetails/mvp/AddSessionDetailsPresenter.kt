package com.mathews.codetracker.modules.addSessionDetails.mvp

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

class AddSessionDetailsPresenter
@Inject constructor(val view: AddSessionDetailsView, val model: AddSessionDetailsModel) {

    private val compositeDisposables = CompositeDisposable()
    private val dateFormatter = DateTimeFormat.forPattern(AppConstants.dateFormat)
    private lateinit var scope : CoroutineScope

    fun onCreate(scope: CoroutineScope) {
        this.scope = scope
        compositeDisposables.add(onSaveClickedObservable())
    }

    fun onBackPressed() {
        model.onBackPressed()
        cancelScope()
    }

    fun onDestroy() {
        cancelScope()
    }

    private fun cancelScope() {
        try {
            scope.cancel()
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    private fun onSaveClickedObservable(): Disposable {
        return view.onSaveClickedObservable().subscribe {
            view.saveDataIntoViewState()
            validateData()
        }
    }

    private fun validateData() {
        if (!view.state.isDataProcessingInProgress) {
            view.state.isDataProcessingInProgress = true
            if (validateRequiredField(view.state.problemTitle)
                && validateRequiredField(view.state.site)
                && validateRequiredField(view.state.level)
                && validateDateTime(view.state.date)
                && validateTime(view.state.time)
            ) {
                saveSessionInDb()
            } else {
                view.state.isDataProcessingInProgress = false
                view.showDataValidationError()
            }
        }
    }

    private fun saveSessionInDb() {
        val entity = SessionEntity(
            view.state.problemTitle ?: "",
            view.state.problemDescription,
            view.state.site ?: "",
            view.state.link,
            view.state.level ?: "",
            view.state.solutionDescription,
            view.state.timeComplexity,
            view.state.spaceComplexity,
            view.state.date ?: "",
            view.state.time ?: ""
        )

        scope.launch(Dispatchers.IO) {
            val isInsertSuccessful = model.insertEntity(entity)
            showMessage(isInsertSuccessful)
            view.state.isDataProcessingInProgress = false
        }
    }

    private fun showMessage(isSuccessful : Boolean) {
        scope.launch(Dispatchers.Main) {
            view.showSuccessOrFailure(isSuccessful)
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