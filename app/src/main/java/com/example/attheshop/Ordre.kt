package com.example.attheshop

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.content_ordre.*
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONArray

class Ordre : AppCompatActivity(), MyRecyclerViewAdapter.ItemClickListener {
    var adapter: MyRecyclerViewAdapter? = null
    private var theView: TextView? = null

    val ordreNummer: ArrayList<String> = ArrayList()
    val nummerplade: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordre)

        theView = findViewById(R.id.theProposition)
        loaddata()

        //Sets the button with "fab" as ID, to go back to the MainActivity
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
        val testWMBTN = findViewById<Button>(R.id.testBTN)

        //Listens for a click on the "customerButton" and activates the intent to go to  "Kunder" activity
        testWMBTN.setOnClickListener {
            testWM()
        }



        /*
        // data to populate the first column of the RecyclerView with (test)
        val ordreNummer: ArrayList<String> = ArrayList()
        ordreNummer.add("1")
        ordreNummer.add("2")
        ordreNummer.add("3")
        ordreNummer.add("4")
        ordreNummer.add("5")
        ordreNummer.add("6")

        // data to populate the second column of the RecyclerView with (test)
        val nummerplade: ArrayList<String> = ArrayList()
        nummerplade.add("AB78521")
        nummerplade.add("HK16502")
        nummerplade.add("BI48615")
        nummerplade.add("SW25621")
        nummerplade.add("NU65448")
        nummerplade.add("HI65731")

         */


    }

    //The workManager function that sends the work request to the worker class to perform a task.
    private fun testWM(){
        val workManager: WorkManager = WorkManager.getInstance(applicationContext)
        val uploadRequest: OneTimeWorkRequest = OneTimeWorkRequest.Builder(orderWorker::class.java).build()
        workManager.enqueue(uploadRequest)
        workManager.getWorkInfoByIdLiveData(uploadRequest.id).observe(this,{
            Test1.text = it.state.name
        })
    }

    private fun loaddata() {
        val stringRequest = StringRequest(Request.Method.GET,
            EndPoints.URL_ROOT,
            { s ->
                try {
                    val internships = JSONArray(s)

                    //Loop the Array
                    for (i in 0 until internships.length()) {
                        Log.e("Message", "ORDRE")

                        val e: JSONObject = internships.getJSONObject(i)

                        //val testText = findViewById<TextView>(R.id.Test1)
                        theView?.text = e.toString()

                        ordreNummer.add(e.getString("Ordrenummer"))
                        nummerplade.add(e.getString("Nummerplade"))

                        val tag1 = "MyActivity"
                        Log.i(tag1, ordreNummer.toString())

                    }
                    // set up the RecyclerView
                    val recyclerView = findViewById<RecyclerView>(R.id.recyclerOrdre)
                    recyclerView.layoutManager = LinearLayoutManager(this)
                    adapter = MyRecyclerViewAdapter(this, ordreNummer, nummerplade)
                    adapter!!.setClickListener(this)
                    recyclerView.adapter = adapter

                } catch (e: JSONException) {
                    Log.e("log_tag", "Error parsing data $e")
                }
            },
            { volleyError ->
                Toast.makeText(
                    applicationContext,
                    volleyError.message,
                    Toast.LENGTH_LONG
                ).show()
            })

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
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
        val intent = Intent(baseContext, ViewOrder::class.java)
        intent.putExtra("Order_ID", adapter!!.getItem((position)) )
        startActivity(intent)
    }
}