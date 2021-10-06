package com.oisab.beers.data

import com.oisab.beers.data.local.BeersListLocalDataSource
import com.oisab.beers.data.remote.BeersListRemoteDataSource
import com.oisab.beers.data.remote.BeersListResponse
import io.reactivex.rxjava3.core.Observable

class SuggestedBeersListRepository(
    private val beersListLocalDataSource: BeersListLocalDataSource,
    private val beersListRemoteDataSource: BeersListRemoteDataSource
) {
    fun fetchBeersList(): Observable<List<BeersListResponse>> {
        return beersListRemoteDataSource.getBeersList().toObservable()
            .flatMap {
                beersListLocalDataSource.saveRemoteResponse(it)
                Observable.just(it)
            }
    }
}