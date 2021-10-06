package com.oisab.beers.data.local

import com.oisab.beers.data.remote.BeersListResponse
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface BeersListLocalDataSource {

    fun loadBeersList(): Single<List<BeersListEntity>> // load beers list in DB

    fun saveRemoteResponse(response: List<BeersListResponse>): Completable
}