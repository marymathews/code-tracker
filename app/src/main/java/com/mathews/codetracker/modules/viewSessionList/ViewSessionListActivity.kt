package com.mathews.codetracker.modules.viewSessionList

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.R
import com.mathews.codetracker.app.MainApplication
import com.mathews.codetracker.modules.viewSessionList.di.DaggerViewSessionListComponent
import com.mathews.codetracker.modules.viewSessionList.di.ViewSessionListModule
import com.mathews.codetracker.modules.viewSessionList.mvp.ViewSessionListPresenter
import com.mathews.codetracker.modules.viewSessionList.mvp.ViewSessionListView
import kotlinx.coroutines.MainScope
import javax.inject.Inject

class ViewSessionListActivity : AppCompatActivity() {

    @Inject lateinit var presenter : ViewSessionListPresenter

    @Inject lateinit var view : ViewSessionListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = DaggerViewSessionListComponent.builder()
            .viewSessionListModule(ViewSessionListModule(this))
            .applicationComponent(MainApplication.instance.getApplicationComponent())
            .build()
        component.injectViewSessionListActivity(this)

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

    companion object {
        fun start(activity: AppCompatActivity) {
            val intent = Intent(activity, ViewSessionListActivity::class.java)
            activity.startActivity(intent)
            activity.overridePendingTransition(R.anim.slide_in_new, R.anim.slide_out_old)
        }
    }
}