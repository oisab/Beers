package com.oisab.beers

import android.app.Application
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
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}