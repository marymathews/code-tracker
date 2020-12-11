package com.mathews.codetracker.modules.viewInsights.mvp

import com.mathews.codetracker.R
import com.mathews.codetracker.app.AppConstants
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.joda.time.format.DateTimeFormat
import java.lang.Exception
import javax.inject.Inject

class ViewInsightsPresenter
@Inject constructor(private val view: ViewInsightsView, private val model: ViewInsightsModel) {

    private val compositeDisposables = CompositeDisposable()
    private lateinit var scope: CoroutineScope


}