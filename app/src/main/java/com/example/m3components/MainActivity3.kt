package com.example.m3components

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.LinearLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity3 : AppCompatActivity() {
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private lateinit var bottomSheetWrapper: LinearLayout
    private lateinit var showBottomSheetButton: Button
    private lateinit var switchMaterial: SwitchMaterial
    private var isBottomSheetVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

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

        // Optionally, you can also toggle the visibility of the bottom sheet based on the switch state
        switchMaterial.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                // Hide the bottom sheet if the switch is turned off
                bottomSheetWrapper.visibility = View.GONE
                isBottomSheetVisible = false
            }
        }
    }
}