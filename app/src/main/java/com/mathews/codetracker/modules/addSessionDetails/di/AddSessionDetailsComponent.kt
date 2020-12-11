package com.mathews.codetracker.modules.addSessionDetails.di

import com.mathews.codetracker.app.di.ApplicationComponent
import com.mathews.codetracker.modules.addSessionDetails.AddSessionDetailsActivity
import dagger.Component

@AddSessionDetailsScope
@Component(modules = [AddSessionDetailsModule::class], dependencies = [ApplicationComponent::class])
interface AddSessionDetailsComponent {
    fun injectAddSessionDetailsActivity(addSessionDetailsActivity: AddSessionDetailsActivity)
}