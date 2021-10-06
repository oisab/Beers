package com.oisab.beers.data.remote

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface BeersApi {
    @GET("./beers")
    fun getBeersList(): Single<List<BeersListResponse>>
}