package com.example.brighams_bears_flashcards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LevelMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // hides action bar
        supportActionBar?.hide()
        // sets layout
        setContentView(R.layout.level_menu)

        // gets all the information passed from the previous intent
        val intent = getIntent()
        val subject = intent.getStringExtra("subject")

        // takes the user back to the previous screen
        val backButton = findViewById<Button>(R.id.backbutton)
        backButton.setOnClickListener {
            finish()
        }

        // initializes count and point to be used throughout the program
        val count = "1"
        val points ="0"

        // sets the difficulty and passes the info to the next screen
        val easyButon = findViewById<Button>(R.id.easybutton)
        easyButon.setOnClickListener{
            val diff = "Easy"
            val i = Intent(this, FlashcardScreen::class.java)
            i.putExtra("diff", diff)
            i.putExtra("subject", subject)
            i.putExtra("count", count)
            i.putExtra("points",points)
            startActivity(i)
        }
        // sets the difficulty and passes the info to the next screen
        val medButton = findViewById<Button>(R.id.mediumbutton)
        medButton.setOnClickListener{
            val diff = "Medium"
            val i = Intent(this, FlashcardScreen::class.java)
            i.putExtra("diff", diff)
            i.putExtra("subject", subject)
            i.putExtra("count", count)
            i.putExtra("points",points)
            startActivity(i)
        }
        // sets the difficulty and passes the info to the next screen
        val harButton = findViewById<Button>(R.id.hardbutton)
        harButton.setOnClickListener{
            val diff = "Hard"
            val i = Intent(this, FlashcardScreen::class.java)
            i.putExtra("diff", diff)
            i.putExtra("subject", subject)
            i.putExtra("count", count)
            i.putExtra("points",points)
            startActivity(i)
        }

    }
}