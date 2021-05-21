package com.example.attheshop

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class ViewBiler : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_biler)
        setSupportActionBar(findViewById(R.id.toolbar))

        val intent = intent
        val data = intent.getStringExtra("Nummerplade")
        val textView = findViewById<TextView>(R.id.ClickedItemBiler)
        textView.text = data

        //Sets the button with "fab" as ID, to go back to the Biler Activity
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, Biler::class.java)

            startActivity(intent)
        }
    }
}