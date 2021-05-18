package com.example.attheshop

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ViewOrder : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_order)

        val intent = intent
        val data = intent.getStringExtra("Order_ID")
        val textView = findViewById<TextView>(R.id.ClickedItem)
        textView.text = data




        //Sets the button with "fab" as ID, to go back to the Ordre Activity
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, Ordre::class.java)

            startActivity(intent)
        }


    }
}