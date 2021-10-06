package com.oisab.beers

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.oisab.beers.BeersListEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class BeersListEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val tagline: String,
    @ColumnInfo(name = "first_brewed")
    val firstBrewed: String,
    val description: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    val abv: Double,
    val ibu: Double,
    @ColumnInfo(name = "target_fg")
    val targetFg: Int,
    @ColumnInfo(name = "target_og")
    val targetOg: Double,
    val ebc: Int,
    val srm: Double,
    val ph: Double,
    @ColumnInfo(name = "attenuation_level")
    val attenuationLevel: Double
) {
    companion object {
        const val TABLE_NAME = "beers_list_entities_table"
    }
}