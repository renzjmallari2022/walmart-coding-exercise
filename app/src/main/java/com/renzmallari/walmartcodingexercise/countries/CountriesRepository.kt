package com.renzmallari.walmartcodingexercise.countries

import com.renzmallari.walmartcodingexercise.network.CountriesApi
import com.renzmallari.walmartcodingexercise.network.CountriesResponseApi

class CountriesRepository {

    suspend fun getAllCountries() = CountriesApi.retrofitService.getAllCountries()
}