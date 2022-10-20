package com.hilguener.superheroapp.model.api

data class Data(
    var offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results:List<Hero>
)
