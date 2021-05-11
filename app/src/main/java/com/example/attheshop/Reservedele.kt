package com.example.attheshop

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.content_reservedele.*


class Reservedele : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservedele)

        //Sets the button with "fab" as ID, to go back to the MainActivity
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

        fun newProduct(view: View) {
            val dbHandler = DatabaseHandler(this, null, null, 1)

            val quantity = Integer.parseInt(productQuantity.text.toString())

            val product = ReservedeleModel(productName.text.toString(), quantity)

            dbHandler.addProduct(product)
            productName.setText("")
            productQuantity.setText("")
        }

        fun lookupProduct(view: View) {
            val dbHandler = DatabaseHandler(this, null, null, 1)

            val product = dbHandler.findProduct(
                    productName.text.toString())

            if (product != null) {
                productID.text = product.id.toString()

                productQuantity.setText(
                        product.quantity.toString())
            } else {
                productID.text = "No Match Found"
            }
        }

        fun removeProduct(view: View) {
            val dbHandler = DatabaseHandler(this, null, null, 1)

            val result = dbHandler.deleteProduct(
                    productName.text.toString())

            if (result) {
                productID.text = "Record Deleted"
                productName.setText("")
                productQuantity.setText("")
            } else
                productID.text = "No Match Found"
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