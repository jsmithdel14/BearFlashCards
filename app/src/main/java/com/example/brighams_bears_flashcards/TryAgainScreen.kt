package com.example.brighams_bears_flashcards

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TryAgainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.try_again_scn)

        val tryAgain = findViewById<Button>(R.id.try_aga)
        tryAgain.setOnClickListener{
            finish()
        }

        val backHome = findViewById<Button>(R.id.back_home_trya)
        backHome.setOnClickListener{
            val i = Intent(this, MainMenu::class.java)
            startActivity(i)
        }



    }
}