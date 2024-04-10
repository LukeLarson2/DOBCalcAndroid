package com.example.dobcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        val birthDayBtn = findViewById<Button>(R.id.birthday_button)

        birthDayBtn.setOnClickListener{
            clickDatePicker()
        }
    }

    fun clickDatePicker() {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
    }
}


