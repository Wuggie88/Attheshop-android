package com.example.attheshop

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.content_view_order.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class ViewOrder : AppCompatActivity() {
    var infoPackage = EndPoints.URL_GETCUS1

    val ordrenummer: ArrayList<String> = ArrayList()
    val pris: ArrayList<String> = ArrayList()
    val nummerplade: ArrayList<String> = ArrayList()
    val aendringer: ArrayList<String> = ArrayList()
    val besked: ArrayList<String> = ArrayList()
    val ordrestatus: ArrayList<String> = ArrayList()
    val telefonnummer: ArrayList<String> = ArrayList()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_order)

        val intent = intent
        val data = intent.getStringExtra("Order_ID")
        val textView = findViewById<TextView>(R.id.OrdreNummer)
        textView.text = data

        if (data == "1") {
            infoPackage = EndPoints.URL_GETCUS1
        } else if (data == "2") {
            infoPackage = EndPoints.URL_GETCUS2
        } else if (data == "3") {
            infoPackage = EndPoints.URL_GETCUS3
        }

        loaddata()


        //Sets the button with "fab" as ID, to go back to the Ordre Activity
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, Ordre::class.java)

            startActivity(intent)
        }


    }

    private fun loaddata() {
        val stringRequest = StringRequest(
            Request.Method.GET,
            infoPackage,
            { s ->
                try {
                    val orderInfo = JSONArray(s)

                    //Loop the Array
                    for (i in 0 until orderInfo.length()) {
                        Log.e("Message", "ORDRE")

                        val e: JSONObject = orderInfo.getJSONObject(i)


                        ordrenummer.add(e.getString("Ordrenummer"))
                        pris.add(e.getString("Pris"))
                        nummerplade.add(e.getString("Nummerplade"))
                        aendringer.add(e.getString("Aendringer"))
                        besked.add(e.getString("Besked"))
                        ordrestatus.add(e.getString("Ordrestatus"))
                        telefonnummer.add(e.getString("Telefonnummer"))


                        val tag1 = "ViewOrder"
                        Log.i(tag1, telefonnummer.toString())

                    }
                    val priceView = findViewById<TextView>(R.id.prisView)
                    val lpView = findViewById<TextView>(R.id.NummerpladeView)
                    val changeView = findViewById<TextView>(R.id.AendringerView)
                    val msgView = findViewById<TextView>(R.id.beskedView)
                    val orderStatusView = findViewById<TextView>(R.id.ordreStatusView)
                    val phoneNumberView = findViewById<TextView>(R.id.tlfView)

                    priceView.text = pris.toString()
                    lpView.text = nummerplade.toString()
                    changeView.text = aendringer.toString()
                    msgView.text = besked.toString()
                    orderStatusView.text = ordrestatus.toString()
                    phoneNumberView.text = telefonnummer.toString()


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
}