package edu.rvccollege.student.cis245final

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var garbageday = ""
        val spin = findViewById<Spinner>(R.id.spinnerWkDay)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val list = arrayOf ("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
        val adapter1 = ArrayAdapter <String> ( this, android.R.layout.simple_spinner_item, list)
        android.R.layout.simple_spinner_item
        android.R.layout.simple_spinner_dropdown_item
        spin.adapter = adapter1
        btnSubmit.setOnClickListener(View.OnClickListener {
            when (spin.selectedItem.toString()){
                "Sunday" -> garbageday = "Sunday"
                "Monday" -> garbageday = "Monday"
                "Tuesday" -> garbageday = "Tuesday"
                "Wednesday" -> garbageday = "Wednesday"
                "Thursday" -> garbageday = "Thursday"
                "Friday" -> garbageday = "Friday"
                "Saturday" -> garbageday = "Saturday:"
            }
            val intent = Intent(this, Main2Activity::class.java)
            intent.putExtra("SendStuff",garbageday)
            startActivity(intent)
        })
    }
}
