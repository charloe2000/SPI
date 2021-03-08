package com.example.activitytest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.second_layout.*

class SecondActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)

        val data = intent.getStringExtra("extra_data")
        Log.d("SecondActivity", "Data is $data")

        button2.setOnClickListener {
            returnActivityData()
        }

        button3.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }

    fun returnActivityData() {
        val intent = Intent()
        intent.putExtra("return_data", "Hello, FirstActivity")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    override fun onBackPressed() {
        returnActivityData()
    }
}