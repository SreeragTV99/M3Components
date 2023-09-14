package com.example.m3components

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val Button = findViewById<Button>(R.id.toMainActivity3)

        Button.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

    val rootView: View = findViewById(android.R.id.content)
    val showSnackbarButton=findViewById<Button>(R.id.showSnackbarButton)
    showSnackbarButton.setOnClickListener {
        Snackbar.make(rootView, "This is a Snackbar", Snackbar.LENGTH_SHORT)
            .setAction("Action") {
                // Action to perform when the user clicks on the action text
                // You can add your custom logic here
            }
            .show()
    }
    }
}