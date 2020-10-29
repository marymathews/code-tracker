package com.mathews.codetracker.modules.selectOption.di

import com.mathews.codetracker.app.di.ApplicationComponent
import com.mathews.codetracker.modules.selectOption.SelectOptionActivity
import dagger.Component

@SelectOptionScope
@Component(modules = [SelectOptionModule::class], dependencies = [ApplicationComponent::class])
interface SelectOptionComponent {
    fun injectSelectOptionActivity(activity: SelectOptionActivity)
}