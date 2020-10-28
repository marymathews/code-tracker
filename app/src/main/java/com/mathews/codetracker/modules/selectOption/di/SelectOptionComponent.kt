package com.mathews.codetracker.modules.selectOption.di

import com.mathews.codetracker.app.di.ApplicationComponent
import dagger.Component

@SelectOptionScope
@Component(modules = [SelectionOptionModule::class], dependencies = [ApplicationComponent::class])
interface SelectOptionComponent {
}