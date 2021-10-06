package com.oisab.beers.data.local

import com.oisab.beers.data.remote.BeersListResponse
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class RoomBeersListDataSource(private val beersListDao: BeersListDao): BeersListLocalDataSource {
    override fun loadBeersList(): Single<List<BeersListEntity>> = beersListDao.loadAllBeers()

    override fun saveRemoteResponse(response: List<BeersListResponse>): Completable {
        return beersListDao.saveAllBeers(response.map {
            BeersListEntity(
                id = it.id,
                name = it.name,
                tagline = it.tagline,
                description = it.description,
                imageUrl = it.imageUrl,
                abv = it.abv,
                ibu = it.ibu,
                targetFg = it.targetFg,
                targetOg = it.targetOg,
                ebc = it.ebc,
                srm = it.srm,
                ph = it.ph,
                attenuationLevel = it.attenuationLevel,
                firstBrewed = it.firstBrewed
            )
        })
    }
}