package com.example.attheshop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_ordre.*

class Ordre : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordre)

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

    }

    private fun testWM(){
        val workManager: WorkManager = WorkManager.getInstance(applicationContext)
        val uploadRequest: OneTimeWorkRequest = OneTimeWorkRequest.Builder(orderWorker::class.java).build()
        workManager.enqueue(uploadRequest)
        workManager.getWorkInfoByIdLiveData(uploadRequest.id).observe(this,{
            Test1.text = it.state.name
        })
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