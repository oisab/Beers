package com.oisab.beers.data.remote

import io.reactivex.rxjava3.core.Single

class RetrofitBeersListDataSource(private val beersApi: BeersApi) : BeersListRemoteDataSource {

    override fun getBeersList(): Single<List<BeersListResponse>> = beersApi.getBeersList()
}