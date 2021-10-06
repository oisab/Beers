package com.oisab.beers.data.local

import androidx.room.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface BeersListDao {
    @Query("SELECT * FROM ${BeersListEntity.TABLE_NAME}")
    fun loadAllBeers() : Single<List<BeersListEntity>>

    @Insert(entity = BeersListEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun addBeersList(beersListEntity: BeersListEntity): Completable

    @Insert(entity = BeersListEntity::class, onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun saveAllBeers(beersListEntity: List<BeersListEntity>): Completable

    @Delete(entity = BeersListEntity::class)
    fun deleteBeersList(beersListEntity: BeersListEntity): Completable
}