package com.example.attheshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //reference variable for the listeners.
        val customerButton = findViewById<Button>(R.id.CustomerButton)
        val carButton = findViewById<Button>(R.id.CarButton)
        val ordersButton = findViewById<Button>(R.id.OrdersButton)
        val lastOpenButton = findViewById<Button>(R.id.LastOpenButton)

        //Listens for a click on the "customerButton" and sends it to "Kunder" activity
        customerButton.setOnClickListener {
            val intent = Intent(this, Kunder::class.java)

            startActivity(intent)

        }

        //Listens for a click on the "carButton" and sends it to "Biler" activity
        carButton.setOnClickListener {
            val intent = Intent(this, Biler::class.java)

            startActivity(intent)
        }

        //Listens for a click on the "ordersButton" and sends it to "Igangvaerendeordre" activity
        ordersButton.setOnClickListener {
            val intent = Intent(this, Igangvaerendeordre::class.java)

            startActivity(intent)
        }

        //Listens for a click on the "lastOpenButton" and sends it to "SenestAabne" activity
        lastOpenButton.setOnClickListener {
            val intent = Intent(this, SenestAabne::class.java)

            startActivity(intent)
        }
    }
}
