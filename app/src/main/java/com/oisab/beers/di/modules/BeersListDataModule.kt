package com.oisab.beers.di.modules

import com.oisab.beers.data.SuggestedBeersListRepository
import com.oisab.beers.data.local.BeersListDatabase
import com.oisab.beers.data.local.BeersListLocalDataSource
import com.oisab.beers.data.local.RoomBeersListDataSource
import com.oisab.beers.data.remote.BeersApi
import com.oisab.beers.data.remote.BeersListRemoteDataSource
import com.oisab.beers.data.remote.RetrofitBeersListDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BeersListDataModule {

    @Provides
    @Singleton
    fun provideLocalDataSource(roomDatabase: BeersListDatabase): BeersListLocalDataSource = RoomBeersListDataSource(roomDatabase.beersListDao())

    @Provides
    @Singleton
    fun provideRemoteDataSource(beersApi: BeersApi): BeersListRemoteDataSource = RetrofitBeersListDataSource(beersApi)

    @Provides
    @Singleton
    fun provideBeersListRepository(local: BeersListLocalDataSource, remote: BeersListRemoteDataSource): SuggestedBeersListRepository =
        SuggestedBeersListRepository(local, remote)
}