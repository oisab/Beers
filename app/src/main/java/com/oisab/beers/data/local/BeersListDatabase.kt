package com.oisab.beers.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        BeersListEntity::class
    ], version = 1, exportSchema = true
)
abstract class BeersListDatabase : RoomDatabase() {

    abstract fun beersListDao(): BeersListDao
}