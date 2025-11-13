package com.example.indigo

import android.app.Dialog
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TicketActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket)

        val flight = intent.getParcelableExtra<Flight>("FLIGHT_DATA")

        // Find views
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val logoIndigo = findViewById<ImageView>(R.id.logoIndigo)
        val tvTicketDate = findViewById<TextView>(R.id.tvTicketDate)
        val tvTicketDeparture = findViewById<TextView>(R.id.tvTicketDeparture)
        val tvTicketArrival = findViewById<TextView>(R.id.tvTicketArrival)
        val tvDepartureAirportName = findViewById<TextView>(R.id.tvDepartureAirportName)
        val tvArrivalAirportName = findViewById<TextView>(R.id.tvArrivalAirportName)
        val tvTicketDuration = findViewById<TextView>(R.id.tvTicketDuration)
        val tvAdultCount = findViewById<TextView>(R.id.tvAdultCount)
        val tvMeal = findViewById<TextView>(R.id.tvMeal)
        val tvPassengerName = findViewById<TextView>(R.id.tvPassengerName)
        val tvFlightType = findViewById<TextView>(R.id.tvFlightType)
        val tvFlightCode = findViewById<TextView>(R.id.tvFlightCode)
        val tvBoardingTime = findViewById<TextView>(R.id.tvBoardingTime)
        val tvGate = findViewById<TextView>(R.id.tvGate)
        val tvTerminal = findViewById<TextView>(R.id.tvTerminal)
        val tvSeatNumber = findViewById<TextView>(R.id.tvSeatNumber)
        val btnDownload = findViewById<Button>(R.id.btnDownload)

        flight?.let {
            logoIndigo.setImageResource(it.logoCom)
            tvTicketDate.text = it.date
            tvTicketDeparture.text = it.departureCode
            tvTicketArrival.text = it.arrivalCode
            tvDepartureAirportName.text = it.departureAirport
            tvArrivalAirportName.text = it.arrivalAirport
            tvTicketDuration.text = it.duration
            tvAdultCount.text = it.adultCount
            tvMeal.text = it.meal
            tvPassengerName.text = it.passengerName
            tvFlightType.text = it.flightType
            tvFlightCode.text = it.flightCode
            tvBoardingTime.text = it.boardingTime
            tvGate.text = it.gate
            tvTerminal.text = it.terminal
            tvSeatNumber.text = it.seatNumber
        }

        btnBack.setOnClickListener {
            finish()
        }

        btnDownload.setOnClickListener {
            showSuccessDialog()
        }
    }

    private fun showSuccessDialog() {
        val dialog = Dialog(this)

        dialog.setContentView(R.layout.alert_layout)

        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            dialog.window?.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
            dialog.window?.attributes?.blurBehindRadius = 50
        }

        val btnOk = dialog.findViewById<Button>(R.id.btnOk)

        btnOk.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}