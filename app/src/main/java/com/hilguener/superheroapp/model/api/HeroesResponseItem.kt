package com.hilguener.superheroapp.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HeroesResponseItem(
    @Expose
    @SerializedName("id") val id: Int,
    @Expose
    @SerializedName("name") val name: String,
    @Expose
    @SerializedName("powerstats") val powerStats: PowerStats,
    @Expose
    @SerializedName("biography") val biography: String,
    @Expose
    @SerializedName("appearance") val appearance: String,
    @Expose
    @SerializedName("work") val work: String,
    @Expose
    @SerializedName("connections") val connections: String,
    @Expose
    @SerializedName("image") val image: String
)