package com.example.attheshop

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Biler : AppCompatActivity(), RecyclerViewAdapter.ItemClickListener {
    var adapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biler)

        //Sets the button with "fab" as ID, to go back to the MainActivity
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

        // data to populate the first column of the RecyclerView with (test)
        val animalNames: ArrayList<String> = ArrayList()
        animalNames.add("Horse")
        animalNames.add("Cow")
        animalNames.add("Camel")
        animalNames.add("Sheep")
        animalNames.add("Goat")
        animalNames.add("Wolf")

        // data to populate the second column of the RecyclerView with (test)
        val animalSounds: ArrayList<String> = ArrayList()
        animalSounds.add("Pfff")
        animalSounds.add("Moo")
        animalSounds.add("Tygge")
        animalSounds.add("Meh")
        animalSounds.add("Beh")
        animalSounds.add("Au")

        // set up the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerCars)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(this, animalNames, animalSounds)
        adapter!!.setClickListener(this)
        recyclerView.adapter = adapter
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

    override fun onItemClick(view: View?, position: Int) {
        Toast.makeText(
                this,
                "You clicked " + adapter!!.getItem(position) + " on row number " + position,
                Toast.LENGTH_SHORT
        ).show()
    }

}