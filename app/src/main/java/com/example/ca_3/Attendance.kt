package com.example.ca_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Attendance : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)

        var section = intent.getStringExtra("Section")
        var textview_section = findViewById<TextView>(R.id.textView8)
        var button = findViewById<Button>(R.id.end)

        textview_section.setText(section.toString())
        button.setOnClickListener(){
            finishAffinity()
        }
    }
}