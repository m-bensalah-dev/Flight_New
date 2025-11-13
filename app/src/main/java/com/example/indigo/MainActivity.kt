package com.example.indigo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var flightAdapter: FlightAdapter
    private lateinit var btn_back: ImageButton
    private var isDualPane = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewFlights)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        val ticketContainer: FrameLayout? = findViewById(R.id.ticket_container)
        isDualPane = (ticketContainer != null)

        val flightList = mutableListOf<Flight>(
            Flight("IndiGo", R.drawable.ic_indigo,R.drawable.logo_indigo, "DEL", "06:30", "Delhi International Airport", "BLR", "10:45", "Bengaluru Airport India", "04h 15m", "6,500", "Paid Meal", "20 December 2022", "Rahul Sharma", "Economy", "6E-3421", "05:30 AM", "B3", "T1", "12C", "01 Adult"),
            Flight("Vistara", R.drawable.ic_vistara, R.drawable.logo_vistera, "DEL", "07:15", "Delhi International Airport", "BLR", "09:40", "Bengaluru Airport India", "02h 25m", "7,319", "Free Meal", "20 December 2022", "Shreya Kumar", "Economy", "IG-2105", "06:15 AM", "A5", "T2", "A5", "01 Adult"),
            Flight("Spicejet", R.drawable.ic_spicejet,R.drawable.logo_spicejet, "DEL", "14:45", "Delhi International Airport", "BLR", "17:20", "Bengaluru Airport India", "02h 35m", "8,100", "Free Meal", "20 December 2022", "Priya Singh", "Business", "SG-804", "13:45 PM", "C7", "T3", "3A", "02 Adult"),
            Flight("Emirates", R.drawable.ic_emirates, R.drawable.logo_emirates, "DEL", "18:00", "Delhi International Airport", "BLR", "20:30", "Bengaluru Airport India", "02h 30m", "5,999", "Paid Meal", "20 December 2022", "Amit Patel", "Economy", "EK-8147", "17:00 PM", "D2", "T2", "18F", "01 Adult")
        )

        flightAdapter = FlightAdapter(flightList) { flight ->
            if (isDualPane) {
                // Mode PAYSAGE: Charger le fragment à droite
                val fragment = TicketFragment.newInstance(flight)
                supportFragmentManager.commit {
                    replace(R.id.ticket_container, fragment)
                }
            } else {
                // Mode PORTRAIT: Lancer la nouvelle activité
                val intent = Intent(this, TicketActivity::class.java)
                intent.putExtra("FLIGHT_DATA", flight)
                startActivity(intent)
            }
        }
        recyclerView.adapter = flightAdapter
        btn_back = findViewById(R.id.back_button)
        btn_back.setOnClickListener {
            finish()
        }


    }
}