package com.renzmallari.walmartcodingexercise.countries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.renzmallari.walmartcodingexercise.databinding.CountryItemBinding
import com.renzmallari.walmartcodingexercise.models.CountriesResponse
import com.renzmallari.walmartcodingexercise.models.CountriesResponseItem

class CountriesAdapter(private val countries: CountriesResponse) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CountryItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        holder.bindData(country)
    }

    class ViewHolder(private val binding: CountryItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(item: CountriesResponseItem) {
            binding.countryName.text = "${item.name}, ${item.region}"
            binding.countryCode.text = "${item.code}"
            binding.countryCapital.text = "${item.capital}"
        }
    }
}