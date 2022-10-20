package com.hilguener.superheroapp.model.api


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HeroApiResponse(
    val heroes : List<HeroResult>
)

data class HeroResult(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName ("name") val name: String,
    @Expose @SerializedName ("powerstats") val powerstats: List<PowerStats>
    )

data class PowerStats(
    @Expose @SerializedName ("intelligence") val intelligence: Int,
    @Expose @SerializedName ("strength") val strength: Int,
    @Expose @SerializedName ("speed") val speed: Int,
    @Expose @SerializedName ("durability") val durability: Int,
    @Expose @SerializedName ("power") val power: Int,
    @Expose @SerializedName ("combat") val combat: Int
)