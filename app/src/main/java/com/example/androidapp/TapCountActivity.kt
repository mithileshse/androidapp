package com.example.androidapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TapCountActivity : AppCompatActivity() {
    private var tapCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tap_count)

        val countText = findViewById<TextView>(R.id.text_tap_count)
        val tapButton = findViewById<Button>(R.id.button_tap)

        updateCountText(countText)

        tapButton.setOnClickListener {
            tapCount += 1
            updateCountText(countText)
        }
    }

    private fun updateCountText(countText: TextView) {
        countText.text = getString(R.string.tap_count_value, tapCount)
    }
}
