package com.example.brighams_bears_flashcards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
//import android.view.Window
//import android.view.WindowManager

class MainMenu  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        requestWindowFeature(Window.FEATURE_NO_TITLE)
//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        setContentView(R.layout.main_menu)

        val backButton = findViewById<Button>(R.id.backbutton)
        backButton.setOnClickListener {
            finish()
        }


        val hisButton = findViewById<Button>(R.id.historybutton)
        hisButton.setOnClickListener{
            val i = Intent(this, LevelMenu::class.java)
            val subject = "History"
            i.putExtra("subject", subject)
            startActivity(i)
        }
        val mathButton = findViewById<Button>(R.id.mathbutton)
        mathButton.setOnClickListener{
            val i = Intent(this, LevelMenu::class.java)
            val subject = "Math"
            i.putExtra("subject", subject)
            startActivity(i)
        }
        val sciButton = findViewById<Button>(R.id.sciencebutton)
        sciButton.setOnClickListener{
            val i = Intent(this, LevelMenu::class.java)
            val subject = "Science"
            i.putExtra("subject", subject)
            startActivity(i)
        }
    }
}