package com.example.earlydays

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity

class myDialog:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?. let {
        val alertDialog = AlertDialog.Builder(it)
        alertDialog.setView(requireActivity().layoutInflater.inflate(R.layout.dialog_main, null))
        alertDialog.setPositiveButton("submit", ({dialog, id ->

        }))

            alertDialog.create()
        }?:throw IllegalStateException("Activity is null !!")
    }
}