package com.example.uiwidgettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var imageId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    fun initListener() {
        button.setOnClickListener {
            val str = editText.text.toString()
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.changeImg_item -> {
                imageId = (imageId + 1) % 2
                if (imageId == 0) {
                    imageView.setImageResource(R.drawable.img_1)
                }
                else {
                    imageView.setImageResource(R.drawable.img_2)
                }
            }

            R.id.changeProBar_item -> {
                if (progressBar.visibility == View.VISIBLE) {
                    progressBar.visibility = View.GONE
                }
                else {
                    progressBar.visibility = View.VISIBLE
                }
            }

            R.id.updateProBar_item -> {
                if (progressBar.progress <= 90) {
                    progressBar.progress += 10
                }
                else {
                    progressBar.progress = 0
                }
            }

            R.id.alertDialog_item -> {
                AlertDialog.Builder(this).apply {
                    setTitle("Dialog")
                    setMessage("Something important.")
                    setCancelable(false)
                    setPositiveButton("OK") {dialog, which -> }
                    setNegativeButton("Cancel") {dialog, which ->}
                    show()
                }
            }
        }
        return true
    }
}