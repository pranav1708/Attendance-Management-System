package com.example.ca_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Parent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent)
        var button = findViewById<Button>(R.id.button2)
        button.setOnClickListener(){
            Toast.makeText(this, "Thank you for visiting the App", Toast.LENGTH_SHORT).show()
            finishAffinity()
        }
    }
}