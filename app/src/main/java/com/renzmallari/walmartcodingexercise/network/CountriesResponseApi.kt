package com.renzmallari.walmartcodingexercise.network

import com.renzmallari.walmartcodingexercise.models.CountriesResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://gist.githubusercontent.com/"
private const val COUNTRIES_URL = "peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface CountriesResponseApi {
    @GET(COUNTRIES_URL)
    suspend fun getAllCountries(): Response<CountriesResponse>
}

object CountriesApi {
    val retrofitService: CountriesResponseApi by lazy {
        retrofit.create(CountriesResponseApi::class.java)
    }
}