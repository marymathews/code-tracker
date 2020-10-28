package com.mathews.codetracker.modules.splash.mvp

import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.modules.selectOption.SelectOptionActivity
import javax.inject.Inject

class SplashScreenModel
@Inject constructor(val activity: AppCompatActivity) {

    fun navigateToSelectOption() {
        SelectOptionActivity.start(activity)
    }
}