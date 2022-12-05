package com.example.brighams_bears_flashcards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TryAgainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // hides action bar
        supportActionBar?.hide()
        // sets layout
        setContentView(R.layout.try_again_scn)

        // gets all the information passed from the previous intent
        val intent = getIntent()
        val subject = intent.getStringExtra("subject")
        val diff = intent.getStringExtra("diff")
        var count = intent.getStringExtra("count")
        var points = intent.getStringExtra("points")

        // subtracts points from the total and modifies the points variable
        if (points != null){
            points = (points.toInt() - 5).toString()
        }

        // takes you back to the question you were on and passes all the info
        val tryAgain = findViewById<Button>(R.id.try_aga)
        tryAgain.setOnClickListener{
            val i = Intent(this, FlashcardScreen::class.java)
            i.putExtra("diff", diff)
            i.putExtra("subject", subject)
            i.putExtra("count", count)
            i.putExtra("points", points)
            startActivity(i)
        }

        // takes the user back to the main menu when button is pushed
        val backHome = findViewById<Button>(R.id.back_home_trya)
        backHome.setOnClickListener{
            val i = Intent(this, MainMenu::class.java)
            startActivity(i)
        }
    }
}