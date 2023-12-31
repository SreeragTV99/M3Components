package com.example.m3components

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.button.MaterialButton
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity3 : AppCompatActivity() {
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private lateinit var bottomSheetWrapper: LinearLayout
    private lateinit var showBottomSheetButton: MaterialButton
    private lateinit var switchMaterial: SwitchMaterial
    private var isBottomSheetVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val nextButton = findViewById<MaterialButton>(R.id.nextScreen)

        nextButton.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }

        val previousButton = findViewById<MaterialButton>(R.id.previousScreen)

        previousButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


        // get reference to the string array that we just created
        val languages = resources.getStringArray(R.array.programming_languages)
        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, languages)
        // get reference to the autocomplete text view
        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        // set adapter to the autocomplete tv to the arrayAdapter
        autocompleteTV.setAdapter(arrayAdapter)


        // Find views
        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.standard_bottom_sheet))
        bottomSheetWrapper = findViewById(R.id.standard_bottom_sheet)
        showBottomSheetButton = findViewById(R.id.showBottumSheet)
        switchMaterial = findViewById(R.id.switchMaterial)

        // Initially hide the entire bottom sheet wrapper
        bottomSheetWrapper.visibility = View.GONE

        // Set an onClickListener for the button to toggle the bottom sheet
        showBottomSheetButton.setOnClickListener {
            if (isBottomSheetVisible) {
                // If the bottom sheet is visible, hide it
                bottomSheetWrapper.visibility = View.GONE
                isBottomSheetVisible = false
            } else {
                // If the bottom sheet is hidden, show it
                bottomSheetWrapper.visibility = View.VISIBLE
                isBottomSheetVisible = true
            }
        }

        switchMaterial.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Switch is checked, enable Dark Theme
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                // Switch is not checked, use the default theme (usually light theme)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }
}