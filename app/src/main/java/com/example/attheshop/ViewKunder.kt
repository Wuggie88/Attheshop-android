package com.example.attheshop

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

class ViewKunder : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_kunder)
        setSupportActionBar(findViewById(R.id.toolbar))

        val intent = intent
        val data = intent.getStringExtra("Navn")
        val textView = findViewById<TextView>(R.id.ClickedItemKunder)
        textView.text = data

        //Sets the button with "fab" as ID, to go back to the Kunder Activity
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, Kunder::class.java)

            startActivity(intent)
        }
    }
}