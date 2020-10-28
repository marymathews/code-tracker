package com.mathews.codetracker.modules.selectOption

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.R

class SelectOptionActivity : AppCompatActivity() {

    companion object {
        fun start(activity: AppCompatActivity) {
            val intent = Intent(activity, SelectOptionActivity::class.java)
            activity.startActivity(intent)
            activity.overridePendingTransition(R.anim.slide_in_new, R.anim.slide_out_old)
            activity.finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_option)
    }
}