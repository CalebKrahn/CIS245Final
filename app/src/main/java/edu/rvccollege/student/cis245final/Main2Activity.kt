package edu.rvccollege.student.cis245final

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Locale.ENGLISH

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val txtMessage = findViewById<TextView>(R.id.txtMessage)
        val btnGarbageDay = findViewById<Button>(R.id.btnGarbageDay)

        var garbageday: String = intent.getStringExtra("SendStuff")

        val day = SimpleDateFormat("EEEE", ENGLISH).format(System.currentTimeMillis())

        btnGarbageDay.setOnClickListener {
            if (garbageday == day)
                txtMessage.setText("Today is ${day}, take out your garbage.")
            else
                txtMessage.setText("Today is ${day}. You don't need to take out your garbage.")
        }
    }
}
