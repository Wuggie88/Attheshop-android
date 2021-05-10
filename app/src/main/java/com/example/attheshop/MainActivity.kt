package com.example.attheshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        //Listens for a click on the "customerButton" and activates the intent to go to  "Kunder" activity
        customerButton.setOnClickListener {
            val intent = Intent(this, Kunder::class.java)

            startActivity(intent)

        }

        //Listens for a click on the "carButton" and activates the intent to go to "Biler" activity
        carButton.setOnClickListener {
            val intent = Intent(this, Biler::class.java)

            startActivity(intent)
        }

        //Listens for a click on the "ordersButton" and activates the intent to go to  "Igangvaerendeordre" activity
        ordersButton.setOnClickListener {
            val intent = Intent(this, Igangvaerendeordre::class.java)

            startActivity(intent)
        }

        //Listens for a click on the "lastOpenButton" and activates the intent to go to  "SenestAabne" activity
        lastOpenButton.setOnClickListener {
            val intent = Intent(this, SenestAabne::class.java)

            startActivity(intent)
        }
    }

    //onStart is is called when activity is visible to the user.
    override fun onStart() {
        super.onStart()

    }

    //onResume is called when the activity is going to the foreground.
    override fun onResume() {
        super.onResume()

    }

    //onRestart is called when you stop the activity after it has already been running.
    override fun onRestart() {
        super.onRestart()
    }

    //onPause is called when an activity goes to the background.
    override fun onPause() {
        super.onPause()

    }

    //onStop is called when the activity is no longer visible but can still save data.
    override fun onStop() {
        super.onStop()

    }

    //onDestroy is called as the last thing in the activity right before it's destroyed.
    override fun onDestroy() {
        super.onDestroy()

    }

}
