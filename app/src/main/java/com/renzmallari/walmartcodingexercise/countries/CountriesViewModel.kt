package com.renzmallari.walmartcodingexercise.countries

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.renzmallari.walmartcodingexercise.models.CountriesResponse
import kotlinx.coroutines.launch

class CountriesViewModel(private val countriesRepository: CountriesRepository) : ViewModel() {

    private val _listOfCountries = MutableLiveData<CountriesResponse>()
    val listOfCountries get() = _listOfCountries

    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch {
            try {
                _listOfCountries.value = countriesRepository.getAllCountries().body()
            } catch (e: Exception) {
                Log.d("Error","error: ${e.message}")
            }
        }
    }
}