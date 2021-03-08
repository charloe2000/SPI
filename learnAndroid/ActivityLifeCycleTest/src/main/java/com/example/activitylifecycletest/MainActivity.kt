package com.example.activitylifecycletest

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "OnCreate")
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            val tmpData = savedInstanceState.getString("saved_data")
            Log.d(tag, "get saved_data")
        }

        startNormalActivity.setOnClickListener {
            val intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
        }
        startDialogActivity.setOnClickListener {
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "OnDestroy")
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "OnStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "OnStop")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "OnPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "OnRestart")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)

        val tmpData = "Something to saved"
        outState.putString("saved_data", tmpData)
    }
}