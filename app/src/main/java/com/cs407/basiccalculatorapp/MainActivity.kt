package com.cs407.basiccalculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextNum1 = findViewById<EditText>(R.id.editTextNum1)
        val editTextNum2 = findViewById<EditText>(R.id.editTextNum2)

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonSubtract = findViewById<Button>(R.id.buttonSubtract)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)

        fun calculateResult(result: Double) {
            val intent = Intent(this, BasicResult::class.java)
            intent.putExtra("result", result)
            startActivity(intent)
        }

        buttonAdd.setOnClickListener {
            val result = editTextNum1.text.toString().toInt() + editTextNum2.text.toString().toInt()
            calculateResult(result.toDouble())
        }

        buttonSubtract.setOnClickListener {
            val result = editTextNum1.text.toString().toInt() - editTextNum2.text.toString().toInt()
            calculateResult(result.toDouble())
        }

        buttonMultiply.setOnClickListener {
            val result = editTextNum1.text.toString().toInt() * editTextNum2.text.toString().toInt()
            calculateResult(result.toDouble())
        }

        buttonDivide.setOnClickListener {
            val result = editTextNum1.text.toString().toInt() / editTextNum2.text.toString().toInt()
            calculateResult(result.toDouble())
        }
    }
}

