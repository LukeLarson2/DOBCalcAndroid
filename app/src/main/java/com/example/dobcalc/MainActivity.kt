package com.example.dobcalc

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate : TextView? = null
    private var minutesAlive : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        val birthDayBtn = findViewById<Button>(R.id.birthday_button)
        tvSelectedDate = findViewById(R.id.formatted_date_text)
        minutesAlive = findViewById(R.id.minutes_age_text)

        birthDayBtn.setOnClickListener{
            clickDatePicker()
        }
    }

    private fun clickDatePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, { _, selectedYear, selectedMonth, dayOfMonth ->
            val formattedText = "${selectedMonth + 1}/$dayOfMonth/$selectedYear"
            tvSelectedDate?.text = formattedText
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)

            val theDate = sdf.parse(formattedText)

            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateInMinutes = ((currentDate?.time)?.div(60000))
            val selectedDateInMinutes = theDate?.time?.div(60000)
            val totalMinutes = selectedDateInMinutes?.let { currentDateInMinutes?.minus(it) }

            minutesAlive?.text = totalMinutes.toString()
        },
            year, month, day
        )
        dpd.datePicker.maxDate = System.currentTimeMillis() - (86400000)
        dpd.show()
    }
}


