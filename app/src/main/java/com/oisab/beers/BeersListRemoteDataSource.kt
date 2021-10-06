package com.oisab.beers

import io.reactivex.rxjava3.core.Single

interface BeersListRemoteDataSource {

    fun getBeersList(): Single<List<BeersListResponse>>
}