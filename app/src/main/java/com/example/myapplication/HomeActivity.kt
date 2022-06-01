package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var helper=MyDBHelper(applicationContext)
        var db=helper.readableDatabase
        val emtxt: EditText = findViewById(R.id.User_txt_ed)
        val pwdtxt: EditText = findViewById(R.id.Pass_txt_ed)
        val signButton: Button = findViewById(R.id.sign)

        signButton.setOnClickListener {
            val Uname: EditText = findViewById(R.id.User_txt_ed)
            val pass: EditText = findViewById(R.id.Pass_txt_ed)
            var args= listOf<String>(emtxt.text.toString(),pwdtxt.text.toString()).toTypedArray()
            var rs=db.rawQuery("SELECT * FROM USERS2 WHERE EMAIL = ? AND PWD =?",args)

            if(rs.moveToNext() && Uname.getText().toString().length != 0 && pass.getText().toString().length != 0 ){

                val dental=Intent(this,Dental::class.java)
                startActivity(dental)

                Toast.makeText(applicationContext,"welcome to dusky dental",Toast.LENGTH_LONG).show()
            }else if( !rs.moveToNext() && Uname.getText().toString().length != 0 && pass.getText().toString().length != 0 ){
                Toast.makeText(applicationContext,"Email or Pasword is not correct ",Toast.LENGTH_LONG).show()
            }

            else{
                Uname.setError( "please fill the required fields " )
                pass.setError( "please fill the required fields " )
            }



        }


        val switch_SignUp: Button = findViewById(R.id.SingUP)
        switch_SignUp.setOnClickListener {
            opeSinup()
        }

        //val switch_dental:Button=findViewById(R.id.sign)
       // switch_dental.setOnClickListener{
           // opendental()
       // }
    }

    private fun opeSinup() {
      val sinup=Intent(this,SignUp::class.java)
        startActivity(sinup)
    }
   // private fun opendental() {
       // val dental=Intent(this,Dental::class.java)
       // val Uname: EditText = findViewById(R.id.User_txt_ed)
       // if( Uname.getText().toString().length == 0 )
         //   Uname.setError( "First name is required!" );
       // val pass: EditText = findViewById(R.id.Pass_txt_ed)
       // if( pass.getText().toString().length == 0)
          //  pass.setError( "Password  is required!" );

        // startActivity(dental)
    }


    

