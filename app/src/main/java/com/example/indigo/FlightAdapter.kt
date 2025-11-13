package com.example.indigo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FlightAdapter(
    private val flightList: MutableList<Flight>,
    private val onItemClick: (Flight) -> Unit
) : RecyclerView.Adapter<FlightAdapter.FlightViewHolder>() {

    class FlightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val airlineLogo: ImageView = itemView.findViewById(R.id.logo)
        val airlineName: TextView = itemView.findViewById(R.id.name)
        val departureCode: TextView = itemView.findViewById(R.id.departureCode)
        val departureTime: TextView = itemView.findViewById(R.id.departureTime)
        val mealInfo: TextView = itemView.findViewById(R.id.meal)
        val duration: TextView = itemView.findViewById(R.id.duration)
        val arrivalCode: TextView = itemView.findViewById(R.id.arrivalCode)
        val arrivalTime: TextView = itemView.findViewById(R.id.arrivalTime)
        val price: TextView = itemView.findViewById(R.id.prix)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)
        return FlightViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        val currentFlight = flightList[position]

        holder.airlineLogo.setImageResource(currentFlight.logo)
        holder.airlineName.text = currentFlight.name
        holder.departureCode.text = currentFlight.departureCode
        holder.departureTime.text = currentFlight.departureTime
        holder.mealInfo.text = currentFlight.meal
        holder.duration.text = currentFlight.duration
        holder.arrivalCode.text = currentFlight.arrivalCode
        holder.arrivalTime.text = currentFlight.arrivalTime
        holder.price.text = currentFlight.prix

        holder.itemView.setOnClickListener {
            onItemClick(currentFlight)
        }
    }

    override fun getItemCount(): Int {
        return flightList.size
    }
}