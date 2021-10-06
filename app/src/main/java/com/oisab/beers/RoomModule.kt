package com.oisab.beers

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    fun provideApplicationContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideBeersListDatabase(applicationContext: Context): BeersListDatabase =
        Room.databaseBuilder(
            applicationContext,
            BeersListDatabase::class.java,
            "beers_list_room_database"
        ).build()
}