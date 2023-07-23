package com.example.ca_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.system.exitProcess

class ParentLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_login)

        var roll_no = findViewById<EditText>(R.id.roll_no)
        var passwd = findViewById<EditText>(R.id.passwd)
        var login = findViewById<Button>(R.id.login)

        login.setOnClickListener(){
            if (roll_no.text.isEmpty() || passwd.text.isEmpty()){
                Toast.makeText(this, "Please enter all the credentials", Toast.LENGTH_LONG).show()
            }
            else{
                var intent = Intent(this, Parent::class.java)
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
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
                finishAffinity()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}