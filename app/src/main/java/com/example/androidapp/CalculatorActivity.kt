package com.example.androidapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {
    private var currentOperation: Operation = Operation.ADDITION

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val inputFirst = findViewById<EditText>(R.id.input_number_one)
        val inputSecond = findViewById<EditText>(R.id.input_number_two)
        val operationText = findViewById<TextView>(R.id.text_operation)
        val resultText = findViewById<TextView>(R.id.text_calculation_result)
        val calculateButton = findViewById<Button>(R.id.button_calculate)

        val addButton = findViewById<Button>(R.id.button_add)
        val subtractButton = findViewById<Button>(R.id.button_subtract)
        val multiplyButton = findViewById<Button>(R.id.button_multiply)
        val divideButton = findViewById<Button>(R.id.button_divide)

        fun updateOperationDisplay() {
            operationText.text = getString(R.string.selected_operation, currentOperation.label)
        }

        addButton.setOnClickListener {
            currentOperation = Operation.ADDITION
            updateOperationDisplay()
        }

        subtractButton.setOnClickListener {
            currentOperation = Operation.SUBTRACTION
            updateOperationDisplay()
        }

        multiplyButton.setOnClickListener {
            currentOperation = Operation.MULTIPLICATION
            updateOperationDisplay()
        }

        divideButton.setOnClickListener {
            currentOperation = Operation.DIVISION
            updateOperationDisplay()
        }

        calculateButton.setOnClickListener {
            val firstValue = inputFirst.text.toString().toDoubleOrNull()
            val secondValue = inputSecond.text.toString().toDoubleOrNull()

            if (firstValue == null || secondValue == null) {
                resultText.text = getString(R.string.invalid_input)
                return@setOnClickListener
            }

            val result = when (currentOperation) {
                Operation.ADDITION -> firstValue + secondValue
                Operation.SUBTRACTION -> firstValue - secondValue
                Operation.MULTIPLICATION -> firstValue * secondValue
                Operation.DIVISION -> {
                    if (secondValue == 0.0) {
                        resultText.text = getString(R.string.divide_by_zero)
                        return@setOnClickListener
                    }
                    firstValue / secondValue
                }
            }

            resultText.text = getString(R.string.calculation_result, result)
        }

        updateOperationDisplay()
    }

    private enum class Operation(val label: String) {
        ADDITION("Addition"),
        SUBTRACTION("Subtraction"),
        MULTIPLICATION("Multiplication"),
        DIVISION("Division")
    }
}
