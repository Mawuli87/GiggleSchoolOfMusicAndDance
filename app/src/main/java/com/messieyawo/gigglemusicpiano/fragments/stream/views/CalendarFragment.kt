package com.messieyawo.gigglemusicpiano.fragments.stream.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import com.messieyawo.gigglemusicpiano.R
import com.messieyawo.gigglemusicpiano.databinding.FragmentCalendarBinding


class CalendarFragment : Fragment() {

    // on below line we are creating
    // variables for text view and calendar view
    lateinit var dateTV: TextView
    lateinit var calendarView: CalendarView
    lateinit var binding: FragmentCalendarBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentCalendarBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initializing variables of
        // list view with their ids.

        // on below line we are adding set on
        // date change listener for calendar view.
        binding.calendarView.setOnDateChangeListener(
            CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
                // In this Listener we are getting values
                // such as year, month and day of month
                // on below line we are creating a variable
                // in which we are adding all the variables in it.
                val Date = (dayOfMonth.toString() + "-"
                        + (month + 1) + "-" + year)

                // set this date in TextView for Display
                binding.idTVDate.text = Date
            })
    }





}