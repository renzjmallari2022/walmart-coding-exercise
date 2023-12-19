package com.renzmallari.walmartcodingexercise.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.renzmallari.walmartcodingexercise.countries.CountriesRepository
import com.renzmallari.walmartcodingexercise.countries.CountriesViewModel

class CountriesViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountriesViewModel(CountriesRepository()) as T
    }
}