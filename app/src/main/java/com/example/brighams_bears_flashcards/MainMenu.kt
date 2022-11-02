package com.example.brighams_bears_flashcards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainMenu  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        val backButton = findViewById<Button>(R.id.backbutton)
        backButton.setOnClickListener{
            finish()
        }
    }
}