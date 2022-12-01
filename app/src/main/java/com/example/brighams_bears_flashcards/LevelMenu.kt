package com.example.brighams_bears_flashcards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
//import android.view.Window
//import android.view.WindowManager

class LevelMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        requestWindowFeature(Window.FEATURE_NO_TITLE)
//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        setContentView(R.layout.level_menu)

        val intent = getIntent()
        val subject = intent.getStringExtra("subject")

        val backButton = findViewById<Button>(R.id.backbutton)
        backButton.setOnClickListener {
            finish()
        }

        val count = "1"
        val points ="0"
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