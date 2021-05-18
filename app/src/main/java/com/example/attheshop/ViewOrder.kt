package com.example.attheshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.content_view_order.*

class ViewOrder : AppCompatActivity() {

    val sessionId = intent.getStringExtra("Order_ID")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_order)



        //Sets the button with "fab" as ID, to go back to the Ordre Activity
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, Ordre::class.java)

            startActivity(intent)
        }

        ClickedItem.text = sessionId

    }
}