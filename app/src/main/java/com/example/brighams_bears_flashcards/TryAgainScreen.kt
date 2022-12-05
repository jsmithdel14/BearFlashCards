package com.example.brighams_bears_flashcards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TryAgainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.try_again_scn)

        val intent = getIntent()
        val subject = intent.getStringExtra("subject")
        val diff = intent.getStringExtra("diff")
        var count = intent.getStringExtra("count")
        var points = intent.getStringExtra("points")

        if (points != null){
            points = (points.toInt() - 5).toString()
        }

        val tryAgain = findViewById<Button>(R.id.try_aga)
        tryAgain.setOnClickListener{
            val i = Intent(this, FlashcardScreen::class.java)
            i.putExtra("diff", diff)
            i.putExtra("subject", subject)
            i.putExtra("count", count)
            i.putExtra("points", points)
            startActivity(i)
        }

        val backHome = findViewById<Button>(R.id.back_home_trya)
        backHome.setOnClickListener{
            val i = Intent(this, MainMenu::class.java)
            startActivity(i)
        }

        //val pointCount =

    }
}