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
    // makes a db variable to be used throughout the file
    private lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // hides action bar
        supportActionBar?.hide()
        // sets layout
        setContentView(R.layout.flachcard_wbutt_scn)

        // gets all the information passed from the previous intent
        val intent = intent
        val subject = intent.getStringExtra("subject")
        val diff = intent.getStringExtra("diff")
        val count = intent.getStringExtra("count")
        var points =intent.getStringExtra("points")

        // intialized the firebase variable
        FirebaseApp.initializeApp(this)
        db = Firebase.firestore

        // This will be for a correct answer, and takes the user to the congrats screen with all the info needed
        val qButtonOne = findViewById<Button>(R.id.Qbut1)
        qButtonOne.setOnClickListener{
            val i = Intent(this, CongratsScreen::class.java)

            i.putExtra("diff", diff)
            i.putExtra("subject", subject)
            i.putExtra("count", count)
            i.putExtra("points",points)

            startActivity(i)
        }
        // This will be a wrong answer, and takes the user to the try again screen with all the info needed
        val qButtonTwo = findViewById<Button>(R.id.Qbut2)
        qButtonTwo.setOnClickListener{
            val i = Intent(this, TryAgainScreen::class.java)
            i.putExtra("diff", diff)
            i.putExtra("subject", subject)
            i.putExtra("count", count)
            i.putExtra("points",points)
            startActivity(i)
        }
        // This will be a wrong answer, and takes the user to the try again screen with all the info needed
        val qButtonThree = findViewById<Button>(R.id.Qbut3)
        qButtonThree.setOnClickListener{
            val i = Intent(this, TryAgainScreen::class.java)
            i.putExtra("diff", diff)
            i.putExtra("subject", subject)
            i.putExtra("count", count)
            i.putExtra("points",points)
            startActivity(i)
        }
        // This will be a wrong answer, and takes the user to the try again screen with all the info needed
        val qButtonFour = findViewById<Button>(R.id.Qbut4)
        qButtonFour.setOnClickListener{
            val i = Intent(this, TryAgainScreen::class.java)
            i.putExtra("diff", diff)
            i.putExtra("subject", subject)
            i.putExtra("count", count)
            i.putExtra("points",points)
            startActivity(i)
        }

        // gets the question text variable from the XML
        val qText = findViewById<TextView>(R.id.Q_text)

        // gets the point text variable from the XML and set's it equal to the points variable passed in earlier
        val pointCount = findViewById<TextView>(R.id.pointsCounter)
        pointCount.text = points

        // gets the data from the database as a map
        db.collection(subject.toString()).document(diff.toString()).get()
                // if the data is pulled correctly
            .addOnSuccessListener { result ->
                // will go through each question and answer set
                result.data?.forEach { (key, value) ->
                    // checks to see which question you are on
                    if (key.startsWith("$count:")){
                        // sets the question text variable to the actual question text
                        qText.text = key
                        // sets the questions variable to a hashmap due to the variable coming is as a hashmap
                        val questions: HashMap<String?, String?>? = value as HashMap<String?, String?>?
                        // goes through each answer in the answer variable (questions)
                        if (questions != null) {
                            for ((k,v) in questions) {
                                // checks to make sure each answer is in the right place
                                if (k == "1"){
                                    // sets the button text variable to the answer text pulled from the database
                                    qButtonOne.text = v
                                } else if (k == "2"){
                                    // sets the button text variable to the answer text pulled from the database
                                    qButtonTwo.text = v
                                } else if (k == "3"){
                                    // sets the button text variable to the answer text pulled from the database
                                    qButtonThree.text = v
                                } else if (k == "4"){
                                    // sets the button text variable to the answer text pulled from the database
                                    qButtonFour.text = v
                                }
                            }
                        }
                    }
                    // check to see if the count is not null
                    else if (count != null) {
                        // checks to see if the user has made it to the end of the question set
                        if (count.equals((result.data!!.size + 1).toString())) {
                            // hides action bar
                            supportActionBar?.hide()
                            // sets the layout
                            setContentView(R.layout.finish_set)

                            // gets the points from the variable intialized above, and sets it equal to the text view element
                            val finalPoints = findViewById<TextView>(R.id.pointsCounterFinal)
                            finalPoints.text = points
                            // takes the user back to the subject selection on pushing the button
                            val subSel = findViewById<Button>(R.id.subjectSelectBut)
                            subSel.setOnClickListener{
                                val i = Intent(this, MainMenu::class.java)
                                startActivity(i)
                            }
                            // takes the user back to the main menu on pushing the button
                            val mainMenu = findViewById<Button>(R.id.mainMenuButton)
                            mainMenu.setOnClickListener {
                                val i = Intent(this, MainActivity::class.java)
                                startActivity(i)
                            }
                        }
                    }

                }
            }
                // if the data is not pulled correctly
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }




    }
}
