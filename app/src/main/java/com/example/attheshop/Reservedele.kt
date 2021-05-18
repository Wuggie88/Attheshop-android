package com.example.attheshop

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.content_reservedele.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Reservedele : AppCompatActivity(), MyRecyclerViewAdapter.ItemClickListener {
    var adapter: MyRecyclerViewAdapter? = null
    var productList: ArrayList<ReservedeleModel> = ArrayList()
    val productIdList: ArrayList<String> = ArrayList()
    val productNameList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservedele)

        //Sets the button with "fab" as ID, to go back to the MainActivity
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

        //creating new product in local database

            fun newProduct() {
                //calls the DatabaseHandler script to make it possible in insert values
                val dbHandler = DatabaseHandler(this, null, null, 1)

                //converts the value in writeable text field with id productQuantity to a string
                val quantity = Integer.parseInt(productQuantity.text.toString())

                //converts the value in writeable text field with id productName to a string and creates array containing this and quantity value
                val product = ReservedeleModel(productName.text.toString(), quantity)

                //inserts product in local database and resets the two writeable text fields.
                dbHandler.addProduct(product)
                productName.setText("")
                productQuantity.setText("")

                findAllProducts()
            }

        //setOnClickListener watches the chosen button and registers if it gets pressed by the user.
        button3.setOnClickListener {
            newProduct()
        }

        //function to search for a product already in the database.
        fun lookupProduct() {
            val dbHandler = DatabaseHandler(this, null, null, 1)

            //converts text in writeable text field with id productName to string and compares the string to database
            val product = dbHandler.findProduct(
                    productName.text.toString())

            //if match found id number in database converts to string
            if (product != null) {
                productID.text = product.id.toString()

                //the stored quantity of found product converts to string and is insert in text field with if productQuantity
                productQuantity.setText(
                        product.quantity.toString())
            }

            //if no match found the text field with text id productID is set to "No Match Found"
            else {
                productID.text = "No Match Found"
            }
        }

        button2.setOnClickListener {
            lookupProduct()
        }

        //function to remove a stored product from database
        fun removeProduct() {
            val dbHandler = DatabaseHandler(this, null, null, 1)

            //compares text from text field with id productName to database and removes from database if found.
            val result = dbHandler.deleteProduct(
                    productName.text.toString())

                //if match is found text field with id productID is set to "Record Deleted"
            if (result) {
                productID.text = "Record Deleted"

                //text fields with id productName and id productQuantity is reset
                productName.setText("")
                productQuantity.setText("")
            } else {

                //if no match in database is found, no changes in database are made and textfield with id productID is set to "No Match Found"
                productID.text = "No Match Found"
            }
            findAllProducts()
        }

        //setOnClickListener watches the chosen button and registers if it gets pressed by the user.
        button.setOnClickListener {
            removeProduct()
        }





        // set up the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recReservedele)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerViewAdapter(this, productIdList, productNameList)
        adapter!!.setClickListener(this)
        recyclerView.adapter = adapter
    }

    //function to search for a product already in the database.
    fun findAllProducts() {
        val dbHandler = DatabaseHandler(this, null, null, 1)

        productList.clear()
        productIdList.clear()
        productNameList.clear()

        //finds the full list of products from database
        productList = dbHandler.findAll()


        //if the list of products is not empty it will add the items to to arrays, which will be used for recyclerview
        if (productList != null) {
            for(item in productList.indices) {
                productIdList.add(""+productList[item].id.toString())
                productNameList.add(""+productList[item].productName.toString())
            }
        } else{
            val TAG = "MyActvity"
            Log.i(TAG, "Products list is empty!")
        }
    }

    //onStart is is called when activity is visible to the user.
    override fun onStart() {
        super.onStart()
        findAllProducts()
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
        val TAG = "MyActvity"
        Log.i(TAG, adapter!!.getItem(position))
        /*Toast.makeText(
            this,
            "You clicked " + adapter!!.getItem(position) + " on row number " + position,
            Toast.LENGTH_SHORT
        ).show()*/
    }

}