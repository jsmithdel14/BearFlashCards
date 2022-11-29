package com.example.brighams_bears_flashcards

//import com.google.firebase.database.DatabaseReference;
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class FlashcardScreen : AppCompatActivity() {
    private lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flachcard_wbutt_scn)

        FirebaseApp.initializeApp(this)
        db = Firebase.firestore

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

        val qText = findViewById<TextView>(R.id.Q_text)



        db.collection("History").document("Easy").get()
            .addOnSuccessListener { result ->
                result.data?.forEach { (key, value) ->
                    if (key.equals("First United States President")){
                        qText.text = key
                        val questions: HashMap<String?, String?>? = value as HashMap<String?, String?>?
                        if (questions != null) {
                            for ((k,v) in questions) {
                                if (k == "1"){
                                    qButtonOne.text = v
                                } else if (k == "2"){
                                    qButtonTwo.text = v
                                } else if (k == "3"){
                                    qButtonThree.text = v
                                } else if (k == "4"){
                                    qButtonFour.text = v
                                }
                            }
                        }
                    }
                    else if (count != null) {
                        if (count.equals("3")) {
                            setContentView(R.layout.finish_set)
                            val subSel = findViewById<Button>(R.id.subjectSelectBut)
                            subSel.setOnClickListener{
                                val i = Intent(this, MainMenu::class.java)
                                startActivity(i)
                            }
                            val mainMenu = findViewById<Button>(R.id.mainMenuButton)
                            mainMenu.setOnClickListener {
                                val i = Intent(this, MainActivity::class.java)
                                startActivity(i)
                            }
                        }
                    }

                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }




    }
}
