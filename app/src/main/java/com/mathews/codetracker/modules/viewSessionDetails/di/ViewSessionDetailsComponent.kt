package com.mathews.codetracker.modules.viewSessionDetails.di

import com.mathews.codetracker.app.di.ApplicationComponent
import com.mathews.codetracker.modules.viewSessionDetails.ViewSessionDetailsActivity
import dagger.Component

@ViewSessionDetailsScope
@Component(modules = [ViewSessionDetailsModule::class], dependencies = [ApplicationComponent::class])
interface ViewSessionDetailsComponent {
    fun injectViewSessionDetailsActivity(activity: ViewSessionDetailsActivity)
}