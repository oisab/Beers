package com.oisab.beers

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