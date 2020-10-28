package com.mathews.codetracker.modules.selectOption.di

import androidx.appcompat.app.AppCompatActivity
import com.mathews.codetracker.modules.selectOption.mvp.SelectOptionModel
import com.mathews.codetracker.modules.selectOption.mvp.SelectOptionPresenter
import com.mathews.codetracker.modules.selectOption.mvp.SelectOptionView
import dagger.Module
import dagger.Provides

@Module
class SelectionOptionModule(private val activity: AppCompatActivity) {

    @Provides
    @SelectOptionScope
    fun selectOptionPresenter(view: SelectOptionView, model: SelectOptionModel) : SelectOptionPresenter {
        return SelectOptionPresenter(view, model)
    }

    @Provides
    @SelectOptionScope
    fun selectOptionModel() : SelectOptionModel {
        return SelectOptionModel(activity)
    }

    @Provides
    @SelectOptionScope
    fun selectOptionView() : SelectOptionView {
        return SelectOptionView(activity)
    }
}