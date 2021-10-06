package com.oisab.beers

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