package com.oisab.beers.data.remote

import io.reactivex.rxjava3.core.Single

interface BeersListRemoteDataSource {

    fun getBeersList(): Single<List<BeersListResponse>>
}