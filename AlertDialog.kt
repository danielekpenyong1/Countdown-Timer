package com.example.countdown_timer

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import java.util.*

class AlertDialog: DialogFragment() {
    var time_inputted: Boolean = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.countdown_dialog, container, false)
        val eventEdit: EditText = rootView.findViewById(R.id.event_time)
        eventEdit.setOnClickListener{
         setDate()
        }
        val addButton = rootView.findViewById<Button>(R.id.button4)
        addButton.setOnClickListener {
            val intent = Intent(this@AlertDialog.requireContext(), CountdownMainActivity::class.java)
            startActivity(intent)



        }
        return rootView
    }
private fun setDate() {
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)
    val dpd = DatePickerDialog(
        this@AlertDialog.requireContext(), DatePickerDialog.OnDateSetListener{view,year,monthofYear,dayofMonth ->
            val returnDate ="${monthofYear + 1} $dayofMonth $year"
            val date = StringHelper.parseDate(
                "MM dd yyyy",
                "MM/dd/yyyy",
                returnDate
            )
            val justAninflater:View = LayoutInflater.from(this@AlertDialog.requireContext()).inflate(R.layout.countdown_dialog, null)
            val eventedit: EditText = justAninflater.findViewById(R.id.event_time)
            eventedit.setText(StringHelper.parseDate("MM/dd/yyyy", "MMM dd yyy", date ))
            eventedit.error = null
        }, year-30,month,day

    )
    dpd.show()
}
}
