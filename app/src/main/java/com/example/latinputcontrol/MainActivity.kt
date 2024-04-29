package com.example.latinputcontrol

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Set a click listener for the back button
        toolbar.setNavigationOnClickListener {
           finish()
        }

        val etDatePicker = findViewById<EditText>(R.id.et_date_picker)

        etDatePicker.setOnClickListener {
            val datePicker = DatePicker(this)

            val dpd = DatePickerDialog(
                this, { view, year, month, dayOfMonth ->
                    etDatePicker.setText("$dayOfMonth-${month + 1}-$year")
                },
                datePicker.year, datePicker.month, datePicker.dayOfMonth
            )
            dpd.show()
        }
    }
}