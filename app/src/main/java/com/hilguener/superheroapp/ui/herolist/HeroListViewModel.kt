package com.hilguener.superheroapp.ui.herolist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hilguener.superheroapp.model.api.HeroesResponse
import com.hilguener.superheroapp.model.api.HeroesResponseItem
import com.hilguener.superheroapp.service.HeroApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroListViewModel(): ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://superheroapi.com/api/1740819866282231/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service : HeroApiService = retrofit.create(HeroApiService::class.java)

    val heroList = MutableLiveData<List<HeroesResponseItem>>()

    fun getHeroList(){
        val call = service.getHeroList()
        call.enqueue(object: Callback<HeroesResponse>{
            override fun onResponse(call: Call<HeroesResponse>, response: Response<HeroesResponse>) {
                response.body()?.let { list ->
                    heroList.postValue(list)}
            }
            override fun onFailure(call: Call<HeroesResponse>, t: Throwable) {
                call.cancel()

                Log.i("yyy", "erro ao carregar lista ${t.message}")
            }
        })
    }
}