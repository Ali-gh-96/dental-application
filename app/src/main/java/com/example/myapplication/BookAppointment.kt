@file:Suppress("DEPRECATION")

package com.example.myapplication

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.*
import java.lang.NullPointerException

class BookAppointment : AppCompatActivity() {

    lateinit var previewSelectedTimeTextView: TextView
    private val timePickerDialogListener: TimePickerDialog.OnTimeSetListener =
        object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {

                // logic to properly handle
                // the picked timings by user
                val formattedTime: String = when {
                    hourOfDay == 0 -> {
                        if (minute < 10) {
                            "${hourOfDay + 12}:0${minute} am"
                        } else {
                            "${hourOfDay + 12}:${minute} am"
                        }
                    }
                    hourOfDay > 12 -> {
                        if (minute < 10) {
                            "${hourOfDay - 12}:0${minute} pm"
                        } else {
                            "${hourOfDay - 12}:${minute} pm"
                        }
                    }
                    hourOfDay == 12 -> {
                        if (minute < 10) {
                            "${hourOfDay}:0${minute} pm"
                        } else {
                            "${hourOfDay}:${minute} pm"
                        }
                    }
                    else -> {
                        if (minute < 10) {
                            "${hourOfDay}:${minute} am"
                        } else {
                            "${hourOfDay}:${minute} am"
                        }
                    }
                }

                previewSelectedTimeTextView.text = formattedTime
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_appointment)
        val Datebtn: Button = findViewById(R.id.PickDate_bt)
        val Timebtn: Button = findViewById(R.id.PickTime_bt)
        val Submit: Button = findViewById(R.id.Submit_bt1)
        val LogOut: Button = findViewById(R.id.LogOut_bt)
        val Cancel: Button = findViewById(R.id.cancel_bt1)
        val dateView: TextView = findViewById(R.id.DateTextView)
        val timeView: TextView = findViewById(R.id.TimeTextView)


        previewSelectedTimeTextView = findViewById<TextView>(R.id.TimeTextView)

        Datebtn.setOnClickListener {
            val newFragment = DatePickerFragment()
            // Show the date picker dialog
            newFragment.show(fragmentManager, "Date Picker")


        }
        Timebtn.setOnClickListener {
            val timePicker: TimePickerDialog = TimePickerDialog(
                // pass the Context
                this,
                // listener to perform task
                // when time is picked
                timePickerDialogListener,
                // default hour when the time picker
                // dialog is opened
                12,
                // default minute when the time picker
                // dialog is opened
                10,
                // 24 hours time picker is
                // false (varies according to the region)
                false
            )

            // then after building the timepicker
            // dialog show the dialog to user
            timePicker.show()

        }
        Cancel.setOnClickListener {
            val sinup = Intent(this, Dental::class.java)
            startActivity(sinup)
        }
        LogOut.setOnClickListener {
            val sinup = Intent(this, HomeActivity::class.java)
            startActivity(sinup)
        }

        var flag: String = "toothache"
        val spinnerVal: Spinner = findViewById(R.id.about)
        var options = arrayOf(
            "Toothache",
            "Bleaching teeth",
            "Tooth implant",
            "Cleaning teeth",
            "Dental braces",
            "Other"
        )
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var flag = options.get(p2);

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }
        Submit.setOnClickListener {
            var date = dateView.text
            var time = timeView.text

//            if(flag =="toothache") {
//                var type ="toothache"
//            }else if(flag == "Bleaching teeth") {
//                var type ="Bleaching teeth"
//
//            }else if(flag == "tooth implant") {
//                var type ="tooth implant"
//
//            }else if(flag == "Cleaning teeth") {
//                var type ="Cleaning teeth"
//
//            }else if(flag == "Dental braces") {
//                var type ="Dental braces"
//
//            }else if(flag == "Other") {
//                var type ="Other"
//            }

            val data: String = "${date}, ${time}, ${flag}"
            if (date == "Picked Date" ||time == "Picked Time " ){
                Toast.makeText(this,
                    "please pick date and time ",
                    Toast.LENGTH_LONG).show()
            }
            else{
            Toast.makeText(this,
                "Appointment boocked successfully -- Appointment Info : ${data}\n ",
                Toast.LENGTH_LONG).show()
        }
        }

    }
}