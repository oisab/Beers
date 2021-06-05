package com.oisab.beers

import android.app.Application
import android.content.res.Resources
import dagger.Module
import dagger.Provides

@Module
class ResourceModule {

    @Provides
    fun resourceProvider(application: Application): Resources {
        return application.applicationContext.resources
    }
}