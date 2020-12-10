package com.mathews.codetracker.modules.viewSessionDetails

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.R
import com.mathews.codetracker.app.AppConstants
import com.mathews.codetracker.app.MainApplication
import com.mathews.codetracker.modules.viewSessionDetails.di.DaggerViewSessionDetailsComponent
import com.mathews.codetracker.modules.viewSessionDetails.di.ViewSessionDetailsModule
import com.mathews.codetracker.modules.viewSessionDetails.mvp.ViewSessionDetailsPresenter
import com.mathews.codetracker.modules.viewSessionDetails.mvp.ViewSessionDetailsView
import kotlinx.coroutines.MainScope
import javax.inject.Inject

class ViewSessionDetailsActivity : AppCompatActivity() {

    companion object {
        fun start(activity: AppCompatActivity, sessionId : Long) {
            val intent = Intent(activity, ViewSessionDetailsActivity::class.java)
            intent.putExtra(AppConstants.SESSION_ID, sessionId)
            activity.startActivity(intent)
            activity.overridePendingTransition(R.anim.slide_in_new, R.anim.slide_out_old)
        }
    }

    @Inject lateinit var view : ViewSessionDetailsView

    @Inject lateinit var presenter : ViewSessionDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = DaggerViewSessionDetailsComponent.builder()
            .viewSessionDetailsModule(ViewSessionDetailsModule(this))
            .applicationComponent(MainApplication.instance.getApplicationComponent())
            .build()
        component.injectViewSessionDetailsActivity(this)

        setContentView(view)
        presenter.onCreate(MainScope(), intent.getLongExtra(AppConstants.SESSION_ID, 0L))
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }
}