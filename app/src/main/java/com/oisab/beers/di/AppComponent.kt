package com.oisab.beers.di

import android.app.Application
import com.oisab.beers.BeersApp
import com.oisab.beers.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(modules = [AndroidInjectionModule::class,
    ActivityBindingModule::class,
    BeersListDataModule::class,
    ResourceModule::class,
    RoomModule::class,
    RemoteModule::class])

@Singleton
interface AppComponent : AndroidInjector<BeersApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}