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
        supportActionBar?.hide()
        setContentView(R.layout.congrats_scn)

        val intent = getIntent()
        val subject = intent.getStringExtra("subject")
        val diff = intent.getStringExtra("diff")
        var count = intent.getStringExtra("count")
        var points = intent.getStringExtra("points")

        if (count != null) {
            count = (count.toInt() + 1).toString()
        }

        if (points != null){
            points = (points.toInt() + 10).toString()
        }

        val conPoints = findViewById<TextView>(R.id.pointsCountCon)
        conPoints.text = points
        val nextQuestion = findViewById<Button>(R.id.next_area)
        nextQuestion.setOnClickListener{
            val i = Intent(this, FlashcardScreen::class.java)
            i.putExtra("diff", diff)
            i.putExtra("subject", subject)
            i.putExtra("count", count)
            i.putExtra("points", points)
            startActivity(i)
        }

        val backHome = findViewById<Button>(R.id.back_home_con)
        backHome.setOnClickListener{
            val i = Intent(this, MainMenu::class.java)
            startActivity(i)
        }
        /*val points = "0"
        val pointadder = findViewById<TextView>(R.id.epoints2)
        if (points != null) {
            points = (points.toInt() + 1)
            }*/
    }
}