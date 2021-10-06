package com.oisab.beers.di.modules

import com.oisab.beers.screens.main.suggestions.SuggestedBeersListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun suggestedBeersListFragment(): SuggestedBeersListFragment
}