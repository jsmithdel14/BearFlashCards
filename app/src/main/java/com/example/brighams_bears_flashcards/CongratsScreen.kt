package com.example.brighams_bears_flashcards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CongratsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.congrats_scn)

        val intent = getIntent()
        val subject = intent.getStringExtra("subject")
        val diff = intent.getStringExtra("diff")
        var count = intent.getStringExtra("count")


        val nextQuestion = findViewById<Button>(R.id.next_area)
        nextQuestion.setOnClickListener{
            val i = Intent(this, FlashcardScreen::class.java)
            i.putExtra("diff", diff)
            i.putExtra("subject", subject)
            i.putExtra("count", count)
            startActivity(i)
        }

        val backHome = findViewById<Button>(R.id.back_home_con)
        backHome.setOnClickListener{
            val i = Intent(this, MainMenu::class.java)
            startActivity(i)
        }
    }
}