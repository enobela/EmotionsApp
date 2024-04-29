package com.example.schoolapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class CourseActivity : AppCompatActivity() {

    lateinit var edcoursetext:EditText
    lateinit var ebtn_add:Button
    lateinit var elistView:ListView
    lateinit var etextview_element:TextView
    lateinit var adapterv:ArrayAdapter<String>

   val  coursesList :MutableList<String> = mutableListOf<String>("DISD0601","BIT0701","DITM0601")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        etextview_element= findViewById(R.id.textView_elements)
        edcoursetext= findViewById(R.id.editTextCourse)
        elistView= findViewById(R.id.listview_courses)
        ebtn_add = findViewById(R.id.btn_add)


        adapterv= ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,coursesList)
        elistView.adapter=adapterv


       // etextview_element.setText(getitems)


        ebtn_add.setOnClickListener{

            val getvalue=edcoursetext.text.toString()


            if(getvalue.isNotEmpty())
         {
        coursesList.add(getvalue)
        adapterv.notifyDataSetChanged()
        edcoursetext.setText("")

           //Toast.makeText(this,GetTotal(),Toast.LENGTH_LONG).show()
       // etextview_element.setText(getitems)
            }
            else{
                Toast.makeText(this,"Please enter a value",Toast.LENGTH_LONG).show()
            }
        }

        elistView.setOnItemLongClickListener{_,_,position, _ -> DeleteItem(position)
        true

        }
    }

    private fun DeleteItem(position:Int)
    {
        if(position<coursesList.size)
        {
            coursesList.removeAt(position)
            adapterv.notifyDataSetChanged()
            Toast.makeText(this,"deleted",Toast.LENGTH_SHORT).show()
        }
    }



}