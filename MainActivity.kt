package com.example.earlydays

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val start_Dialog:View = findViewById(R.id.floating_button)
        start_Dialog.setOnClickListener{
            val dialog_box:View = LayoutInflater.from(this). inflate(R.layout.dialog_main, null)
            val dialog_button = dialog_box.findViewById<Button>(R.id.add_eventButton)
            val dialog_builder = AlertDialog.Builder(this)
                .setView(dialog_box)
                .setTitle("Event details")
            dialog_builder.show()
        }
    }
}
