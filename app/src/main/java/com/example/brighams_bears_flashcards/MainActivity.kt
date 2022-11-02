package com.example.brighams_bears_flashcards

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonNextHome = findViewById<Button>(R.id.nextbuttonhome)
        buttonNextHome.setOnClickListener{
            setContentView(R.layout.main_menu)
            val backB = findViewById<Button>(R.id.backbutton)
            backB.setOnClickListener{setContentView(R.layout.activity_main)}
        }

        val test = 2;
     }
}