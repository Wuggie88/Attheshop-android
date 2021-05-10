package com.example.attheshop

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class Biler : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biler)

        //Sets the button with "fab" as ID, to go back to the MainActivity
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
        
    }
}