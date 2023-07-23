package com.example.ca_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var teacher = findViewById<Button>(R.id.teacher)
        var student = findViewById<Button>(R.id.student)
        var parent = findViewById<Button>(R.id.parent)


        teacher.setOnClickListener(){
            var intent = Intent(this, TeacherLogin::class.java)
            Toast.makeText(this, "Opening Teacher View", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        student.setOnClickListener(){
            var intent = Intent(this, StudentLogin::class.java)
            Toast.makeText(this, "Opening Student View", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        parent.setOnClickListener(){
            var intent = Intent(this, ParentLogin::class.java)
            Toast.makeText(this, "Opening Parent View", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return when(id){
            R.id.exit -> {
                finish()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}