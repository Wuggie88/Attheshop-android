package com.example.attheshop

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Kunder : AppCompatActivity(), MyRecyclerViewAdapter.ItemClickListener {
    var adapter: MyRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kunder)

        //Sets the button with "fab" as ID, to go back to the MainActivity
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

        // data to populate the first column of the RecyclerView with (test)
        val navn: ArrayList<String> = ArrayList()
        navn.add("Kasper")
        navn.add("Michelle")
        navn.add("Jens")
        navn.add("Nickolai")
        navn.add("Anders")

        // data to populate the second column of the RecyclerView with (test)
        val nummer: ArrayList<String> = ArrayList()
        nummer.add("15384159")
        nummer.add("65982314")
        nummer.add("78915213")
        nummer.add("98643721")
        nummer.add("68318462")

        // set up the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerKunder)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerViewAdapter(this, navn, nummer)
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