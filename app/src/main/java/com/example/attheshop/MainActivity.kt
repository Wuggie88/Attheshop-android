package com.example.attheshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customerButton = findViewById<Button>(R.id.CustomerButton)

        customerButton.setOnClickListener {
            val intent = Intent(this, Kunder::class.java)

            startActivity(intent)
        }
    }
}
