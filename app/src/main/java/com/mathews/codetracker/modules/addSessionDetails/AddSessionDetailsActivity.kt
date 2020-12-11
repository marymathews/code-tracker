package com.mathews.codetracker.modules.addSessionDetails

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.R
import com.mathews.codetracker.app.MainApplication
import com.mathews.codetracker.modules.addSessionDetails.di.AddSessionDetailsModule
import com.mathews.codetracker.modules.addSessionDetails.di.DaggerAddSessionDetailsComponent
import com.mathews.codetracker.modules.addSessionDetails.mvp.AddSessionDetailsPresenter
import com.mathews.codetracker.modules.addSessionDetails.mvp.AddSessionDetailsView
import kotlinx.coroutines.MainScope
import javax.inject.Inject

class AddSessionDetailsActivity : AppCompatActivity() {

    companion object {
        fun start(activity: AppCompatActivity) {
            val intent = Intent(activity, AddSessionDetailsActivity::class.java)
            activity.startActivity(intent)
            activity.overridePendingTransition(R.anim.slide_in_new, R.anim.slide_out_old)
        }
    }

    @Inject lateinit var view : AddSessionDetailsView

    @Inject lateinit var presenter : AddSessionDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = DaggerAddSessionDetailsComponent.builder()
            .addSessionDetailsModule(AddSessionDetailsModule(this))
            .applicationComponent(MainApplication.instance.getApplicationComponent())
            .build()
        component.injectAddSessionDetailsActivity(this)

        setContentView(view)
        presenter.onCreate(MainScope())
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}