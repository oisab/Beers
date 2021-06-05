package com.oisab.beers

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun suggestedBeersListFragment(): SuggestedBeersListFragment
}