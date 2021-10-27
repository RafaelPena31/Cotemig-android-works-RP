package com.example.travelcalc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    /*
    * AUTOR DO PROJETO
    * Matrícula: 11901322
    * Número de chamada: 46
    * Nome: Rafael Augusto Pena Pereira Mesquita
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcSpent = findViewById<Button>(R.id.buttonCalcSpent)
        val distanceInputValue = findViewById<EditText>(R.id.distanceInput).text
        val priceInputValue = findViewById<EditText>(R.id.priceInput).text
        val autonomyInputValue = findViewById<EditText>(R.id.autonomyInput).text
        val resultLabel = findViewById<TextView>(R.id.resultLabel)

        btnCalcSpent.setOnClickListener {
            if(distanceInputValue.isEmpty() || priceInputValue.isEmpty() || autonomyInputValue.isEmpty() || distanceInputValue.toString() == "." ||
                priceInputValue.toString() == "." || autonomyInputValue.toString() == "." || distanceInputValue.toString().toDouble() <= 0 ||
                priceInputValue.toString().toDouble() <= 0 || autonomyInputValue.toString().toDouble() <= 0) {
                val resultTxt = "R$ 0"
                resultLabel.text = resultTxt
            } else {
                val calc = (distanceInputValue.toString().toDouble() * priceInputValue.toString().toDouble()) / autonomyInputValue.toString().toDouble()
                val resultTxt = NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(calc)
                resultLabel.text = resultTxt
            }
        }
    }
}