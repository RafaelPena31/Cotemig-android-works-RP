package com.example.provatrimestral11901322

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.provatrimestral11901322.Classes.Product
import java.text.NumberFormat
import java.util.*

class ProductDetail : AppCompatActivity() {

    /*
    * AUTOR DO PROJETO
    * MATRÍCULA: 11901322
    * NÚMERO DE CHAMADA: 46
    * NOME: RAFAEL AUGUSTO PENA PEREIRA MESQUITA
    * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)


        val productName = intent.getStringExtra("productName")
        val productDescription = intent.getStringExtra("productDescription")
        val productValue = intent.getDoubleExtra("productValue", 0.0)

        val nameTV = findViewById<TextView>(R.id.productNameTV)
        val descriptionTV = findViewById<TextView>(R.id.productDescriptionTV)
        val valueTV = findViewById<TextView>(R.id.productValueTV)

        nameTV.text = productName
        descriptionTV.text = productDescription
        valueTV.text = "Valor do produto: ${NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(productValue)}"

        val backButton = findViewById<Button>(R.id.backButton)

        backButton.setOnClickListener(View.OnClickListener {
            val mainActivy = Intent(this, MainActivity::class.java)

            startActivity(mainActivy)
            finishAffinity()
        })
    }
}