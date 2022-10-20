package com.hilguener.superheroapp.ui.heroinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hilguener.superheroapp.model.api.HeroesResponseItem
import com.hilguener.superheroapp.service.HeroApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroInfoViewModel(): ViewModel() {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://superheroapi.com/1740819866282231/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service : HeroApiService = retrofit.create(HeroApiService::class.java)

    val heroInfo = MutableLiveData<HeroesResponseItem>()

    fun getHeroInfo(id: Int){
        val call = service.getHeroInfo(id)

        call.enqueue(object : Callback<HeroesResponseItem>{
            override fun onResponse(
                call: Call<HeroesResponseItem>, response: Response<HeroesResponseItem>) {
               response.body()?.let { hero ->
                   heroInfo.postValue(hero)
               }
            }
            override fun onFailure(call: Call<HeroesResponseItem>, t: Throwable) {
                call.cancel()
            }
        })
    }
}