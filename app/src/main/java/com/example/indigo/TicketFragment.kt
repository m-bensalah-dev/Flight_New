package com.example.indigo

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.app.Dialog
import android.view.WindowManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TicketFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TicketFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var flight: Flight? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                flight = it.getParcelable("FLIGHT_DATA", Flight::class.java)
            } else {
                @Suppress("DEPRECATION")
                flight = it.getParcelable("FLIGHT_DATA")
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ticket, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flight?.let {
            val tvTicketDate = view.findViewById<TextView>(R.id.tvTicketDate)
            val tvTicketDeparture = view.findViewById<TextView>(R.id.tvTicketDeparture)
            val tvTicketArrival = view.findViewById<TextView>(R.id.tvTicketArrival)
            val tvDepartureAirportName = view.findViewById<TextView>(R.id.tvDepartureAirportName)
            val tvArrivalAirportName = view.findViewById<TextView>(R.id.tvArrivalAirportName)
            val tvTicketDuration = view.findViewById<TextView>(R.id.tvTicketDuration)
            val tvAdultCount = view.findViewById<TextView>(R.id.tvAdultCount)
            val tvMeal = view.findViewById<TextView>(R.id.tvMeal)
            val tvPassengerName = view.findViewById<TextView>(R.id.tvPassengerName)
            val tvFlightType = view.findViewById<TextView>(R.id.tvFlightType)
            val tvFlightCode = view.findViewById<TextView>(R.id.tvFlightCode)
            val tvBoardingTime = view.findViewById<TextView>(R.id.tvBoardingTime)
            val tvGate = view.findViewById<TextView>(R.id.tvGate)
            val tvTerminal = view.findViewById<TextView>(R.id.tvTerminal)
            val tvSeatNumber = view.findViewById<TextView>(R.id.tvSeatNumber)
            val btnDownload = view.findViewById<Button>(R.id.btnDownload)

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
            btnDownload.setOnClickListener {
                showSuccessDialog()
            }
        }
    }
    private fun showSuccessDialog() {
        // Utiliser requireContext() au lieu de 'this' dans un Fragment
        val dialog = Dialog(requireContext())

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

    companion object {
        // Méthode pour créer le fragment
        fun newInstance(flight: Flight): TicketFragment {
            val fragment = TicketFragment()
            val args = Bundle()
            args.putParcelable("FLIGHT_DATA", flight)
            fragment.arguments = args
            return fragment
        }
    }
}