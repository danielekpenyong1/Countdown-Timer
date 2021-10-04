package com.example.countdown_timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView

class CountdownMainActivity : AppCompatActivity() {
    var Start_time = 60000L
    lateinit var countdown_timer:CountDownTimer
    var isRunning: Boolean = false
    var time_in_milliseconds = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.countdown_main)
        val intent = intent
        val receivedcountdowntime = intent.getLongExtra("countdown time",10)
        time_in_milliseconds = receivedcountdowntime*60000L
        startTimer(time_in_milliseconds)
        val newTimer:View = findViewById(R.id.floatingActionButton2)
        newTimer.setOnClickListener{
            addnewTimer()
        }
        val Pauser:Button = findViewById(R.id.button)
        Pauser.setOnClickListener{
            pauseTimer()
        }
    }
    private fun updateTextUI() {
    val minute = (time_in_milliseconds/1000)/60
    val seconds = (time_in_milliseconds/ 1000)%60
    val timer = findViewById<TextView>(R.id.textView2)
      timer.text = "$minute:$seconds"
    }
    private fun startTimer(time_in_seconds:Long){
        countdown_timer = object :CountDownTimer(time_in_seconds, 1000){
            override fun onFinish() {
                resetTimer()
                val newtimeragain:View = findViewById(R.id.floatingActionButton2)
                newtimeragain.visibility = View.VISIBLE
                val pausingEnds:Button = findViewById(R.id.button)
                pausingEnds.visibility=View.INVISIBLE
            }

            override fun onTick(p0:Long){
                time_in_milliseconds = p0
                updateTextUI()
            }
        }

        countdown_timer.start()
        isRunning=true
        val newtimer:View = findViewById(R.id.floatingActionButton2)
        newtimer.visibility = View.INVISIBLE}
    private fun resetTimer() {
        time_in_milliseconds = Start_time
        updateTextUI()
        val reset_timer = findViewById<Button>(R.id.button2)
        reset_timer.visibility = View.INVISIBLE
    }
    private fun addnewTimer() {
        setContentView(R.layout.countdown_dialog)
        startTimer(time_in_milliseconds)
    }
    private fun pauseTimer() {
        val pausebutton:Button = findViewById(R.id.button)
        pausebutton.text = "Start"
        countdown_timer.cancel()

    }
}