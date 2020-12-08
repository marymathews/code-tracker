package com.mathews.codetracker.modules.viewSessionList.di

import com.mathews.codetracker.app.di.ApplicationComponent
import com.mathews.codetracker.modules.viewSessionList.ViewSessionListActivity
import dagger.Component

@ViewSessionListScope
@Component(modules = [ViewSessionListModule::class], dependencies = [ApplicationComponent::class])
interface ViewSessionListComponent {
    fun injectViewSessionListActivity(viewSessionListActivity: ViewSessionListActivity)
}