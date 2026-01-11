package com.example.androidapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InchesToCmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inches_to_cm)

        val inputInches = findViewById<EditText>(R.id.input_inches)
        val resultText = findViewById<TextView>(R.id.text_cm_result)
        val convertButton = findViewById<Button>(R.id.button_convert)

        convertButton.setOnClickListener {
            val inchesValue = inputInches.text.toString().toDoubleOrNull()
            if (inchesValue == null) {
                resultText.text = getString(R.string.invalid_input)
            } else {
                val cmValue = inchesValue * 2.54
                resultText.text = getString(R.string.cm_result, cmValue)
            }
        }
    }
}
