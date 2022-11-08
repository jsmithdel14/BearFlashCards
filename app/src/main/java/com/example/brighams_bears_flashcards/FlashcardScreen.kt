package com.example.brighams_bears_flashcards

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore


class FlashcardScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flachcard_wbutt_scn)

        val database = FirebaseFirestore.getInstance()
        val ref = database.collection("History").document("Easy")

        val qText = findViewById<TextView>(R.id.Q_text)
        ref.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                    val pres = document.data!!["First United States President"].toString()
                    qText.text = pres
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
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