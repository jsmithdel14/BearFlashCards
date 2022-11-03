package com.example.brighams_bears_flashcards

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LevelMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level_menu)

        val backButton = findViewById<Button>(R.id.backbutton)
        backButton.setOnClickListener {
            finish()
        }
    }
}