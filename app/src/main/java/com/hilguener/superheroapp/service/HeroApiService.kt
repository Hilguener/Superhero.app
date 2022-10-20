package com.hilguener.superheroapp.service

import com.hilguener.superheroapp.model.api.HeroesResponse
import com.hilguener.superheroapp.model.api.HeroesResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroApiService {
    @GET("heroes/{id}")
    fun getHeroInfo (@Path("id") id: Int ): Call<HeroesResponseItem>
    @GET ("heroes")
    fun getHeroList (): Call<HeroesResponse>
}