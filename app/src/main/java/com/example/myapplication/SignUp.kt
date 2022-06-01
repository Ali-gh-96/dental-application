package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        var helper=MyDBHelper(applicationContext)
        var db=helper.readableDatabase
        var rs=db.rawQuery("SELECT * FROM USERS2",null)
        val button: Button = findViewById(R.id.CreateAc)
        val fntxt: EditText = findViewById(R.id.Fname)
        val lntxt: EditText = findViewById(R.id.Lname)
        val pwdtxt: EditText = findViewById(R.id.TextPassword)
        val phtxt: EditText = findViewById(R.id.TextPhone)
        val emtxt: EditText = findViewById(R.id.TextEmail)



        button.setOnClickListener {
            var cv= ContentValues()
            cv.put("FNAME", fntxt.text.toString())
            cv.put("LNAME", lntxt.text.toString())
            cv.put("PWD", pwdtxt.text.toString())
            cv.put("PHONE",phtxt.text.toString())
            cv.put("EMAIL", emtxt.text.toString())





            db.insert("USERS2",null,cv)

            fntxt.setText("")
            lntxt.setText("")
            pwdtxt.setText("")
            phtxt.setText("")
            emtxt.setText("")
            fntxt.requestFocus()
            lntxt.requestFocus()



        val gettoast:Button=findViewById(R.id.CreateAc)
        gettoast.setOnClickListener{
            val email:EditText = findViewById(R.id.TextEmail)
        if(email.getText().toString().length != 0) {
                Toast.makeText(applicationContext,"THANK YOU FOR signing UP",Toast.LENGTH_SHORT).show()
                val book= Intent(this,HomeActivity::class.java)
                startActivity(book)
        }else email.setError( "please fill the required fields " )

        }
    }

    }
}