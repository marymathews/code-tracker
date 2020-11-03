package com.mathews.codetracker.modules.selectOption

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.R
import com.mathews.codetracker.app.MainApplication
import com.mathews.codetracker.modules.selectOption.di.DaggerSelectOptionComponent
import com.mathews.codetracker.modules.selectOption.di.SelectOptionModule
import com.mathews.codetracker.modules.selectOption.mvp.SelectOptionPresenter
import com.mathews.codetracker.modules.selectOption.mvp.SelectOptionView
import javax.inject.Inject

class SelectOptionActivity : AppCompatActivity() {

    companion object {
        fun start(activity: AppCompatActivity) {
            val intent = Intent(activity, SelectOptionActivity::class.java)
            activity.startActivity(intent)
            activity.overridePendingTransition(R.anim.slide_in_new, R.anim.slide_out_old)
            activity.finish()
        }
    }

    @Inject lateinit var view : SelectOptionView

    @Inject lateinit var presenter : SelectOptionPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = DaggerSelectOptionComponent.builder()
            .selectOptionModule(SelectOptionModule(this))
            .applicationComponent(MainApplication.instance.getApplicationComponent())
            .build()
        component.injectSelectOptionActivity(this)

        setContentView(view)
        presenter.onCreate()
    }
}