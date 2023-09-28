package com.example.m3components

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.Button
import android.widget.CheckedTextView
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity4 : AppCompatActivity() {

    private lateinit var btnDatePicker: FloatingActionButton
    private var isViewStubInflated = false
    private lateinit var viewStub: ViewStub
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        OnClickTime()

        val Button = findViewById<Button>(R.id.toMainActivity5)

        Button.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)
        }


        btnDatePicker = findViewById(R.id.floating_action_button)

        btnDatePicker.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.show(supportFragmentManager, "DatePicker")

            datePicker.addOnPositiveButtonClickListener {
                val dateFormatter = SimpleDateFormat("dd-MM-yyyy")
                val date = dateFormatter.format(Date(it))
                Toast.makeText(this, "$date is selected", Toast.LENGTH_LONG).show()
            }

            datePicker.addOnNegativeButtonClickListener {
                Toast.makeText(this, "${datePicker.headerText} is cancelled", Toast.LENGTH_LONG)
                    .show()
            }

            datePicker.addOnCancelListener {
                Toast.makeText(this, "Date Picker Cancelled", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun OnClickTime() {
        val textView = findViewById<TextView>(R.id.textView)
        val timePicker = findViewById<TimePicker>(R.id.timePickerView)
        timePicker.setOnTimeChangedListener { _, hour, minute ->
            var hour = hour
            var am_pm = ""

            when {
                hour == 0 -> {
                    hour += 12
                    am_pm = "AM"
                }

                hour == 12 -> am_pm = "PM"
                hour > 12 -> {
                    hour -= 12
                    am_pm = "PM"
                }

                else -> am_pm = "AM"
            }
            if (textView != null) {
                val hour = if (hour < 10) "0" + hour else hour
                val min = if (minute < 10) "0" + minute else minute
                // display format of time
                val msg = "Time is : $hour : $min $am_pm"
                textView.text = msg
                textView.visibility = ViewGroup.VISIBLE
            }
        }


//        // Find the FloatingActionButton by its ID
//        val fab: FloatingActionButton = findViewById(R.id.floating_action_button_BadgeDrawable)
//
//        // Create a BadgeDrawable instance and attach it to the FloatingActionButton
//        val badgeDrawable = BadgeDrawable.create(this)
//        badgeDrawable.number = 3  // Set the badge count
//
//        // Attach the badge to the FloatingActionButton
//        BadgeDrawable.attachBadgeDrawable(badgeDrawable, fab)

        viewStub = findViewById(R.id.viewStub)

        findViewById<MaterialButton>(R.id.inflateButton).setOnClickListener {
            if (!isViewStubInflated) {
                viewStub.inflate()
                isViewStubInflated = true
            }
        }

        val CheckedTView = findViewById<CheckedTextView>(R.id.ctv)
        if(CheckedTView != null){
            CheckedTView.isChecked = false
            CheckedTView.setCheckMarkDrawable(android.R.drawable.checkbox_off_background)
            CheckedTView.setOnClickListener{
                CheckedTView.isChecked = !CheckedTView.isChecked
                CheckedTView.setCheckMarkDrawable(
                    if(CheckedTView.isChecked)
                        android.R.drawable.checkbox_on_background
                    else
                        android.R.drawable.checkbox_off_background
                )

                val msg = getString(R.string.msg_shown)+ "" +
                        getString(if (CheckedTView.isChecked)
                                    R.string.checked
                                else R.string.unchecked)
                Toast.makeText(this@MainActivity4, msg, Toast.LENGTH_SHORT).show()
            }
        }

    }
}