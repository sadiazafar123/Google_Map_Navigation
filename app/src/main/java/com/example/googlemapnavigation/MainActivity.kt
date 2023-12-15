package com.example.googlemapnavigation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    lateinit var editTextSource:EditText
    lateinit var editTextDestination:EditText
    lateinit var btnSubmit:AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextSource=findViewById(R.id.source)
        editTextDestination=findViewById(R.id.destination)
        btnSubmit=findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener(){
            val source:String=editTextSource.text.toString()
            val destination:String=editTextDestination.text.toString()
            if (source.isEmpty() && destination.isEmpty()){
                Toast.makeText(this, " plz enter source and destination", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val uri:Uri =Uri.parse("https://www.google.com/maps/dir/" + source + "/" + destination)
                val intent:Intent= Intent(Intent.ACTION_VIEW,uri)
                intent.setPackage("com.google.android.apps.maps")
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }



    }
}}