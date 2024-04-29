package com.example.schoolapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    lateinit var ebtnNext :Button
    lateinit var ebtnLogin: Button
    lateinit var edtextName: EditText
    lateinit var epassword:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // Assign the btn_nextPage to ebtnNext
        ebtnNext= findViewById(R.id.btn_nextpage)
        ebtnLogin=findViewById(R.id.button_login)
        edtextName=findViewById(R.id.editUsername)
        epassword=findViewById(R.id.editTextTextPassword)
        //Button clicked
        ebtnNext.setOnClickListener{

            val intetCourseAct= Intent(this,CourseActivity::class.java)

            startActivity(intetCourseAct)

        }
//button clicked
        ebtnLogin.setOnClickListener {
           // call login method
            val _username=edtextName.text.toString()
            val _password=epassword.text.toString()
             Login(_username,_password)
            true
        }

    }

    // Login method to validate the user
    private  fun Login(username:String,password:String)
    {
    // you will implement the logic to login into the app
     if(edtextName.equals("Admin") && epassword.equals("Password1"))
     {
       val intent1= Intent(this,CourseActivity::class.java)
       startActivity(intent1)
     }
        else{

            Toast.makeText(this,"Wrong credentials",Toast.LENGTH_SHORT).show()
        }
    }
}