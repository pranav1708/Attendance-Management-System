package com.example.ca_3

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Complaint : AppCompatActivity() {
    lateinit var sharedPreference : SharedPreferences
    var myFile = "Details"
    var Reg = "reg_no"
    var data = "complaint_data"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complaint)

        sharedPreference = getSharedPreferences(myFile, Context.MODE_PRIVATE)
        var reg_no = findViewById<EditText>(R.id.reg_no)
        var complaint = findViewById<EditText>(R.id.complaint)
        var submit = findViewById<Button>(R.id.raise)

        submit.setOnClickListener(){
            if (reg_no.text.toString().isEmpty() || complaint.text.toString().isEmpty()){
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
            else{
                var builder = AlertDialog.Builder(this)
                builder.setTitle("Log Complaint Alert")
                    .setMessage("Are you sure want to raise the complaint?")
                    .setCancelable(true)
                    .setIcon(android.R.drawable.ic_dialog_alert)

                builder.setPositiveButton("Yes"){dialogInterface, which ->
                    Toast.makeText(this, "Raised Complaint Successfully", Toast.LENGTH_SHORT).show()
                    var reg_num = reg_no.text.toString()
                    var subject = complaint.text.toString()
                    var edit = sharedPreference.edit()
                    edit.putString(Reg, reg_num)
                    edit.putString(data, subject)
                    edit.apply()
                    finishAffinity()
                }
                builder.setNegativeButton("NO"){dialogInterface, which ->
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
                }
                var alertDialog : AlertDialog = builder.create()
                alertDialog.show()
            }
        }
    }
}