package com.example.indigo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Flight(
    val name: String,
    val logo: Int,
    val logoCom: Int,
    val departureCode: String,
    val departureTime: String,
    val departureAirport: String,
    val arrivalCode: String,
    val arrivalTime: String,
    val arrivalAirport: String,
    val duration: String,
    val prix: String,
    val meal: String,
    val date: String,
    val passengerName: String,
    val flightType: String,
    val flightCode: String,
    val boardingTime: String,
    val gate: String,
    val terminal: String,
    val seatNumber: String,
    val adultCount: String
) : Parcelable