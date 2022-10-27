package com.example.brighams_bears_flashcards

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseUtils {
    private val fireStoreDatabase = FirebaseFirestore.getInstance()

    private fun readData() {
            FirebaseUtils().fireStoreDatabase.collection("History")
                .get()
                .addOnSuccessListener { querySnapshot ->
                    querySnapshot.forEach { document ->
                        Log.d(TAG, "Read document with ID ${document.id}")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents $exception")

                }
        }
}