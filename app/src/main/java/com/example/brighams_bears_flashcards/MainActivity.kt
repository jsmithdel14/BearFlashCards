package com.example.brighams_bears_flashcards

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonNextHome = findViewById<Button>(R.id.nextbuttonhome)
        buttonNextHome.setOnClickListener {
            val i = Intent(this, MainMenu::class.java)
            startActivity(i)
        }

        //for try again
        //val tryaB = findViewById<Button>(R.id.try_aga)
        //tryaB.setOnClickListener{setContentView(R.layout.flachcard_wbutt_scn)}
        //val homeB = findViewById<Button>(R.id.back_home_trya)
        //homeB.setOnClickListener{setContentView(R.layout.main_menu)}

        //        buttonNextHome.setOnClickListener{
//            setContentView(R.layout.main_menu)
//
//            val hiB = findViewById<Button>(R.id.historybutton)
//            val mathB = findViewById<Button>(R.id.mathbutton)
//            val sciB = findViewById<Button>(R.id.sciencebutton)
//            val swB = findViewById<Button>(R.id.sightwordbutton)
//
//            hiB.setOnClickListener{setContentView(R.layout.level_menu)}
//            mathB.setOnClickListener{setContentView(R.layout.level_menu)}
//            sciB.setOnClickListener{setContentView(R.layout.level_menu)}
//            swB.setOnClickListener{setContentView(R.layout.level_menu)}
//
////            val backB = findViewById<Button>(R.id.backbutton)
////            backB.setOnClickListener{setContentView(R.layout.activity_main)}
//        }

//        val buttonNextHome = findViewById<Button>(R.id.nextbuttonhome)
     }
}