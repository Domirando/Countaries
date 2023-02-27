package com.example.countaries

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import coil.load
import com.example.countaries.databinding.CountryBinding

class CountryAdapter(context: Context, var countries:MutableList<Country>):ArrayAdapter<Country>(context, R.layout.country,countries) {
    override fun getCount(): Int {
        return countries.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val countryItem:CountryBinding
        if (convertView==null){
            countryItem = CountryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        }else{
            countryItem = CountryBinding.bind(convertView)
        }
        var country = countries.get(position)
        countryItem.cname.text = country.name
        countryItem.like.text = country.like.toString()
        countryItem.flag.load(country.flag)
        countryItem.moreInfo.setOnClickListener {
//            var intent = Intent(this, CountryInfo::class.java)
//            startActivity(intent)

        }
        return countryItem.root
    }
}