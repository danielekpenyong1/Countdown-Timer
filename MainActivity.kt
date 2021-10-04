package com.example.countdown_timer

import android.app.DatePickerDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val start_button: View = findViewById(R.id.floatingActionButton)
        start_button.setOnClickListener {
            val eventdialog = Dialog(this)
            eventdialog.setCancelable(true)
            eventdialog.setTitle("Please Enter your event details here")
            eventdialog.setContentView(R.layout.countdown_dialog)
            val inflatelayout = LayoutInflater.from(this).inflate(R.layout.countdown_dialog, null)
            val eventEdit = inflatelayout.findViewById<EditText>(R.id.event_time)
            eventEdit.setOnClickListener {

                setDate()
            }
        eventdialog.show()}
    }

    private fun setDate() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener{ view, year, monthofYear, dayofMonth ->
                val returnDate ="${monthofYear + 1} $dayofMonth $year"
                val date = StringHelper.parseDate(
                    "MM dd yyyy",
                    "MM/dd/yyyy",
                    returnDate
                )
                val justAninflater:View = LayoutInflater.from(this).inflate(R.layout.countdown_dialog, null)
                val eventedit: EditText = justAninflater.findViewById(R.id.event_time)
                eventedit.setText(StringHelper.parseDate("MM/dd/yyyy", "MMM dd yyy", date ))
                eventedit.error = null
            }, year-30,month,day

        )
        dpd.show()}
}

