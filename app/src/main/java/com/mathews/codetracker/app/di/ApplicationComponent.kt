package com.mathews.codetracker.app.di

import dagger.Component

@ApplicationScope
@Component(modules = [ContextModule::class])
interface ApplicationComponent {
}