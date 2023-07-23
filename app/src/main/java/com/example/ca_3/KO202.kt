package com.example.ca_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class KO202 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ko202)
        var mark = findViewById<Button>(R.id.mark)
        var section = intent.getStringExtra("Section")

        mark.setOnClickListener(){
            var builder = AlertDialog.Builder(this)
            builder.setTitle("Mark Attendance")
                .setMessage("Are you sure want to mark Attendance?")
                .setCancelable(true)
                .setIcon(android.R.drawable.ic_dialog_alert)

            builder.setPositiveButton("Yes") {dialogInterface, which ->
                val intent = Intent(this, Attendance::class.java)
                intent.putExtra("Section", section)
                startActivity(intent)
            }
            builder.setNegativeButton("No"){dialogInterface, which ->
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
            }
            var alertDialog : AlertDialog = builder.create()
            alertDialog.show()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.details_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return when(id){
            R.id.exit -> {
                finishAffinity()
                true
            }
            R.id.getDetails -> {
                finish()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}