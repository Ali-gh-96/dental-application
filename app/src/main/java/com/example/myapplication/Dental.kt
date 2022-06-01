package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Dental : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dental)

            val switch_Book:Button=findViewById(R.id.buttonBook)
            switch_Book.setOnClickListener{
                openbook()
            }

        val Cancel:Button=findViewById(R.id.buttonCancel)
        Cancel.setOnClickListener{
            Toast.makeText(this, "Canceld Appointment Sucssefully", Toast.LENGTH_SHORT).show()
        }

        }
    private fun openbook() {
        val book=Intent(this,BookAppointment::class.java)
        startActivity(book)

    }




}

