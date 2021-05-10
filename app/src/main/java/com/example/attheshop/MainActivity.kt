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
        val carButton = findViewById<Button>(R.id.CarButton)
        val ordersButton = findViewById<Button>(R.id.OrdersButton)
        val lastOpenButton = findViewById<Button>(R.id.LastOpenButton)

        customerButton.setOnClickListener {
            val intent = Intent(this, Kunder::class.java)

            startActivity(intent)

        }

        carButton.setOnClickListener {
            val intent = Intent(this, Biler::class.java)

            startActivity(intent)
        }

        ordersButton.setOnClickListener {
            val intent = Intent(this, Igangvaerendeordre::class.java)

            startActivity(intent)
        }

        lastOpenButton.setOnClickListener {
            val intent = Intent(this, SenestAabne::class.java)

            startActivity(intent)
        }
    }
}
