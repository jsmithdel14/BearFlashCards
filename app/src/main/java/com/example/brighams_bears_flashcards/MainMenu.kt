package com.example.brighams_bears_flashcards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainMenu  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // hides action bar
        supportActionBar?.hide()
        // sets layout
        setContentView(R.layout.main_menu)

        // takes the user back to the previous screen
        val backButton = findViewById<Button>(R.id.backbutton)
        backButton.setOnClickListener {
            finish()
        }

        // sets the subject and passes the info to the next screen
        val hisButton = findViewById<Button>(R.id.historybutton)
        hisButton.setOnClickListener{
            val i = Intent(this, LevelMenu::class.java)
            val subject = "History"
            i.putExtra("subject", subject)
            startActivity(i)
        }
        // sets the subject and passes the info to the next screen
        val mathButton = findViewById<Button>(R.id.mathbutton)
        mathButton.setOnClickListener{
            val i = Intent(this, LevelMenu::class.java)
            val subject = "Math"
            i.putExtra("subject", subject)
            startActivity(i)
        }
        // sets the subject and passes the info to the next screen
        val sciButton = findViewById<Button>(R.id.sciencebutton)
        sciButton.setOnClickListener{
            val i = Intent(this, LevelMenu::class.java)
            val subject = "Science"
            i.putExtra("subject", subject)
            startActivity(i)
        }
    }
}