package com.example.ca_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Student : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        var exit = findViewById<Button>(R.id.button2)
        var complaint = findViewById<Button>(R.id.button3)
        exit.setOnClickListener(){
            Toast.makeText(this, "Thank you for visiting the App", Toast.LENGTH_SHORT).show()
            finishAffinity()
        }
        complaint.setOnClickListener(){
            val intent = Intent(this, Complaint::class.java)
            startActivity(intent)
        }
    }
}