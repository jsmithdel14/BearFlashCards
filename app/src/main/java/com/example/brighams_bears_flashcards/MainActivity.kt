package com.example.brighams_bears_flashcards

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // hides action bar
        supportActionBar?.hide()
        // sets layout
        setContentView(R.layout.activity_main)

        // takes the user to the subject selection menu
        val buttonNextHome = findViewById<Button>(R.id.nextbuttonhome)
        buttonNextHome.setOnClickListener {
            val i = Intent(this, MainMenu::class.java)
            startActivity(i)
        }
     }
}
