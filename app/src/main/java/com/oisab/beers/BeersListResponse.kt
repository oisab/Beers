package com.oisab.beers

import com.google.gson.annotations.SerializedName

data class BeersListResponse(
    val id: Int,
    val name: String,
    val tagline: String,
    @SerializedName("first_brewed")
    val firstBrewed: String,
    val description: String,
    @SerializedName("image_url")
    val imageUrl: String,
    val abv: Double,
    val ibu: Double,
    @SerializedName("target_fg")
    val targetFg: Int,
    @SerializedName("target_og")
    val targetOg: Double,
    val ebc: Int,
    val srm: Double,
    val ph: Double,
    @SerializedName("attenuation_level")
    val attenuationLevel: Double
)