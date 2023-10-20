package com.example.m3components

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val Button = findViewById<Button>(R.id.toMainActivity3)
        val textInputLayout: TextInputLayout = findViewById(R.id.nickNameLayout)
        val textInputEditText: AppCompatEditText = findViewById(R.id.nickNameInput)


        Button.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        val rootView: View = findViewById(android.R.id.content)
        val showSnackbarButton = findViewById<Button>(R.id.showSnackbarButton)
        showSnackbarButton.setOnClickListener {
            Snackbar.make(rootView, "This is a Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Action") {
                    // Action to perform when the user clicks on the action text
                    // You can add your custom logic here
                }
                .show()
        }

        textInputEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val inputText = s.toString()
                val pattern =
                    "^[a-zA-Z0-9\\s\u0621-\u064A]+$" // Regular expression for English, Arabic, numbers, and spaces

                if (Pattern.matches(pattern, inputText)) {
                    textInputLayout.error = null // Clear error message
                } else {
                    textInputLayout.error =
                        "Use only English or, Arabic letters, numbers, or spaces"
                }
            }
        })
    }
}