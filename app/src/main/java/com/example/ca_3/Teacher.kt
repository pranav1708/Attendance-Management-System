package com.example.ca_3

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import java.util.*

class Teacher : AppCompatActivity() {
    lateinit var selectedSection : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)

        var date = findViewById<EditText>(R.id.dateinput)
        var time = findViewById<EditText>(R.id.timeinput)
        var spinner = findViewById<Spinner>(R.id.spinner)
        var details = findViewById<Button>(R.id.details)
        var sections = arrayOf("KO201", "KO202", "KO203")
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sections)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                selectedSection = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        details.setOnClickListener(){
            if (date.text.toString().isEmpty() || time.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show()
            }
            else if(selectedSection == "KO201"){
                var intent = Intent(this, KO201::class.java)
                intent.putExtra("Section", selectedSection)
                Toast.makeText(this, "Getting KO201 details", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
            else if (selectedSection == "KO202"){
                var intent = Intent(this, KO202::class.java)
                intent.putExtra("Section", selectedSection)
                Toast.makeText(this, "Getting KO202 details", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
            else if (selectedSection == "KO203"){
                var intent = Intent(this, KO203::class.java)
                intent.putExtra("Section", selectedSection)
                Toast.makeText(this, "Getting KO203 details", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }
    }
    fun showDatePickerDialog(view: View){
        var calendar = Calendar.getInstance()
        var dateInput = findViewById<EditText>(R.id.dateinput)
        var date = calendar[Calendar.DAY_OF_MONTH]
        var month = calendar[Calendar.MONTH]
        var year = calendar[Calendar.YEAR]
        var datePickerDialog : DatePickerDialog
        datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, yearSelected, monthOfYear, dayOfMonth ->
            dateInput.setText("$dayOfMonth/${monthOfYear+1}/$yearSelected")}, year, month, date)
        datePickerDialog.show()
    }

    fun showTimePickerDialog(view: View){
        var timeInput = findViewById<EditText>(R.id.timeinput)
        var calendar = Calendar.getInstance()
        var hour = calendar[Calendar.HOUR_OF_DAY]
        var minute = calendar[Calendar.MINUTE]
        var timePickerDialog : TimePickerDialog
        timePickerDialog = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minuteOfDay ->
            timeInput.setText("$hourOfDay:$minuteOfDay")}, hour, minute, false)
        timePickerDialog.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.login_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return when(id){
            R.id.exit -> {
                finishAffinity()
                true
            }
            R.id.logout -> {
                finish()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}