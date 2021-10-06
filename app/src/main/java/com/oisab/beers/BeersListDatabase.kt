package com.oisab.beers

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