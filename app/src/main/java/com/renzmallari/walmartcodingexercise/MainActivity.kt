package com.renzmallari.walmartcodingexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.renzmallari.walmartcodingexercise.countries.CountriesAdapter
import com.renzmallari.walmartcodingexercise.countries.CountriesViewModel
import com.renzmallari.walmartcodingexercise.databinding.ActivityMainBinding
import com.renzmallari.walmartcodingexercise.utils.CountriesViewModelFactory

class MainActivity : AppCompatActivity() {

    private val countriesViewModel : CountriesViewModel by viewModels { CountriesViewModelFactory() }
    private lateinit var binding: ActivityMainBinding
    private lateinit var countriesAdapter: CountriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        observeCountriesData()
        setContentView(binding.root)
    }

    private fun observeCountriesData() {
        countriesViewModel.listOfCountries.observe(this, Observer {
            countriesAdapter = CountriesAdapter(it)
            setUpRecyclerView()
        })
    }

    private fun setUpRecyclerView() {
        binding.countriesRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
            addItemDecoration(DividerItemDecoration(baseContext, LinearLayoutManager(context).orientation))
        }
    }
}