package com.liondevlab.myweather.city

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.liondevlab.myweather.R

/**
 * My Weather
 * Created by LioNDeVLaB on 17/05/2022
 */
class CityAdapter(private val cities: List<City>,
                  private val cityListener: CityAdapter.CityItemListener) : Adapter<CityAdapter.ViewHolder>(),
    View.OnClickListener {

    interface CityItemListener {
        fun onCitySelected(city: City)
        fun onCityDeleted(city: City)
    }

    class ViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val cardView = itemView.findViewById<CardView>(R.id.city_item_card_view)
        val cityNameView = itemView.findViewById<TextView>(R.id.city_name)
        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_city, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = cities[position]
        with(holder) {
            cardView.tag = city
            cardView.setOnClickListener(this@CityAdapter)
            cityNameView.text = city.name
        }
    }

    override fun getItemCount(): Int = cities.size

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.city_item_card_view -> cityListener.onCitySelected(v.tag as City)
        }
    }
}