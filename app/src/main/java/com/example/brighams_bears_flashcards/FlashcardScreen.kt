package com.example.brighams_bears_flashcards

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
//import com.google.firebase.database.DatabaseReference;
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase


class FlashcardScreen : AppCompatActivity() {
    private lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flachcard_wbutt_scn)

        val qText = findViewById<TextView>(R.id.Q_text)

        FirebaseApp.initializeApp(this)
        db = Firebase.firestore

        db.collection("History").document("Easy").get()
            .addOnSuccessListener{ result ->
                    val pres = result.data.toString()
                    qText.text = pres
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }


        val qButtonOne = findViewById<Button>(R.id.Qbut1)
        qButtonOne.setOnClickListener{
            // Change this for whatever it may be depending on the question
            val i = Intent(this, CongratsScreen::class.java)
            startActivity(i)
        }
        val qButtonTwo = findViewById<Button>(R.id.Qbut2)
        qButtonTwo.setOnClickListener{
            // Change this for whatever it may be depending on the question
            val i = Intent(this, TryAgainScreen::class.java)
            startActivity(i)
        }
        val qButtonThree = findViewById<Button>(R.id.Qbut3)
        qButtonThree.setOnClickListener{
            // Change this for whatever it may be depending on the question
            val i = Intent(this, TryAgainScreen::class.java)
            startActivity(i)
        }
        val qButtonFour = findViewById<Button>(R.id.Qbut4)
        qButtonFour.setOnClickListener{
            // Change this for whatever it may be depending on the question
            val i = Intent(this, TryAgainScreen::class.java)
            startActivity(i)
        }


    }
}
