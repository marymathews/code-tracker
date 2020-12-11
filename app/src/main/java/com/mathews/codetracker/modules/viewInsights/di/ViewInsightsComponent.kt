package com.mathews.codetracker.modules.viewInsights.di

import com.mathews.codetracker.app.di.ApplicationComponent
import com.mathews.codetracker.modules.viewInsights.ViewInsightsActivity
import dagger.Component

@ViewInsightsScope
@Component(modules = [ViewInsightsModule::class], dependencies = [ApplicationComponent::class])
interface ViewInsightsComponent {
    fun injectViewInsightsActivity(viewInsightsActivity: ViewInsightsActivity)
}