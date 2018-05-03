# My Final App
## Caleb Krahn

### This is the website for my Final App in my CIS-245 Introduction to Android Programming class.

## Description
This app is used to determine whether you need to take your garbage out or not. It does not take into account for holidays or delayed garbage days. The app should ask which day your garage is taken, then get what the current day of the week is, then tell you whether you need to take your garbage out or not.
  
## Code  
### First Activity
'''
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
            intent.putExtra("SendStuff", garbageday)
            startActivity(intent)
        })
    }
}
'''
### Second Activity
'''
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
'''
