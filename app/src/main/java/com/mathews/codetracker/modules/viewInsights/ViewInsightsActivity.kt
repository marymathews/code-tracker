package com.mathews.codetracker.modules.viewInsights

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.R
import com.mathews.codetracker.app.MainApplication
import com.mathews.codetracker.modules.viewInsights.di.DaggerViewInsightsComponent
import com.mathews.codetracker.modules.viewInsights.di.ViewInsightsModule
import com.mathews.codetracker.modules.viewInsights.mvp.ViewInsightsPresenter
import com.mathews.codetracker.modules.viewInsights.mvp.ViewInsightsView
import kotlinx.coroutines.MainScope
import javax.inject.Inject

class ViewInsightsActivity : AppCompatActivity() {

    @Inject lateinit var presenter : ViewInsightsPresenter

    @Inject lateinit var view : ViewInsightsView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = DaggerViewInsightsComponent.builder()
            .viewInsightsModule(ViewInsightsModule(this))
            .applicationComponent(MainApplication.instance.getApplicationComponent())
            .build()
        component.injectViewInsightsActivity(this)

        setContentView(view)
        presenter.onCreate(MainScope())
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }


    companion object {
        fun start(activity: AppCompatActivity) {
            val intent = Intent(activity, ViewInsightsActivity::class.java)
            activity.startActivity(intent)
            activity.overridePendingTransition(R.anim.slide_in_new, R.anim.slide_out_old)
        }
    }
}