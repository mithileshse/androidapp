package com.example.androidapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_inches_to_cm).setOnClickListener {
            startActivity(Intent(this, InchesToCmActivity::class.java))
        }

        findViewById<Button>(R.id.button_tap_count).setOnClickListener {
            startActivity(Intent(this, TapCountActivity::class.java))
        }

        findViewById<Button>(R.id.button_bmi).setOnClickListener {
            startActivity(Intent(this, BmiActivity::class.java))
        }

        findViewById<Button>(R.id.button_explicit_intent).setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }

        findViewById<Button>(R.id.button_calculator).setOnClickListener {
            startActivity(Intent(this, CalculatorActivity::class.java))
        }
    }
}
