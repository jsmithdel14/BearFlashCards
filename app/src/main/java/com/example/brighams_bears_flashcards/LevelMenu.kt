package com.example.brighams_bears_flashcards

import android.content.Intent
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

        val easyButon = findViewById<Button>(R.id.easybutton)
        easyButon.setOnClickListener{
            val i = Intent(this, FlashcardScreen::class.java)
            startActivity(i)
        }
        val medButton = findViewById<Button>(R.id.mediumbutton)
        medButton.setOnClickListener{
            val i = Intent(this, FlashcardScreen::class.java)
            startActivity(i)
        }
        val harButton = findViewById<Button>(R.id.hardbutton)
        harButton.setOnClickListener{
            val i = Intent(this, FlashcardScreen::class.java)
            startActivity(i)
        }
    }
}