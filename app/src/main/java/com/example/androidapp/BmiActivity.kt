package com.example.androidapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BmiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        val inputWeight = findViewById<EditText>(R.id.input_weight)
        val inputHeight = findViewById<EditText>(R.id.input_height)
        val resultText = findViewById<TextView>(R.id.text_bmi_result)
        val calculateButton = findViewById<Button>(R.id.button_calculate_bmi)

        calculateButton.setOnClickListener {
            val weight = inputWeight.text.toString().toDoubleOrNull()
            val height = inputHeight.text.toString().toDoubleOrNull()

            if (weight == null || height == null || height <= 0.0) {
                resultText.text = getString(R.string.invalid_input)
            } else {
                val bmiValue = weight / (height * height)
                val category = when {
                    bmiValue < 18.5 -> getString(R.string.bmi_underweight)
                    bmiValue < 25.0 -> getString(R.string.bmi_normal)
                    bmiValue < 30.0 -> getString(R.string.bmi_overweight)
                    else -> getString(R.string.bmi_obese)
                }
                resultText.text = getString(R.string.bmi_result, bmiValue, category)
            }
        }
    }
}
