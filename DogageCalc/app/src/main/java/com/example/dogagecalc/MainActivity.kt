package com.example.dogagecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/*
* PROJECT AUTHOR
* NAME: RAFAEL AUGUSTO PENA PEREIRA MESQUITA
* REGISTRATION: 11901322
* CALL NUMBER: 46
* */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcAge = findViewById<Button>(R.id.buttonCalcAge)
        val inputCalcAge = findViewById<EditText>(R.id.inputCalcAge)
        val txtResult = findViewById<TextView>(R.id.resultLabel)
        val dogAgeValue = 7

        btnCalcAge.setOnClickListener {
            val resultLabel = getString(R.string.main_screen_result_label)
            val result = "$resultLabel ${inputCalcAge.text.toString().toInt() * dogAgeValue}"
            txtResult.text = result
        }
    }
}