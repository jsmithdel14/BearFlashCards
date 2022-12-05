package com.example.brighams_bears_flashcards

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CongratsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // hides action bar
        supportActionBar?.hide()
        // sets layout
        setContentView(R.layout.congrats_scn)

        // gets all the information passed from the previous intent
        val intent = getIntent()
        val subject = intent.getStringExtra("subject")
        val diff = intent.getStringExtra("diff")
        var count = intent.getStringExtra("count")
        var points = intent.getStringExtra("points")

        // adds 1 to the count to make sure we are on the right question
        if (count != null) {
            count = (count.toInt() + 1).toString()
        }

        // adds 10 points per each correct answer
        if (points != null){
            points = (points.toInt() + 10).toString()
        }

        // adds the points to the text view
        val conPoints = findViewById<TextView>(R.id.pointsCountCon)
        conPoints.text = points

        // passes all the updated data to the next flashcard screen when the user clicks on the button
        val nextQuestion = findViewById<Button>(R.id.next_area)
        nextQuestion.setOnClickListener{
            val i = Intent(this, FlashcardScreen::class.java)
            i.putExtra("diff", diff)
            i.putExtra("subject", subject)
            i.putExtra("count", count)
            i.putExtra("points", points)
            startActivity(i)
        }

        // takes the user back to the main menu when button is pushed
        val backHome = findViewById<Button>(R.id.back_home_con)
        backHome.setOnClickListener{
            val i = Intent(this, MainMenu::class.java)
            startActivity(i)
        }
    }
}