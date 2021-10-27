package com.example.provatrimestral11901322

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.provatrimestral11901322.Adapters.ProductRecyclerVIeAdapter
import com.example.provatrimestral11901322.Classes.Product
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    /*
    * AUTOR DO PROJETO
    * MATRÍCULA: 11901322
    * NÚMERO DE CHAMADA: 46
    * NOME: RAFAEL AUGUSTO PENA PEREIRA MESQUITA
    * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.productRecyclerView)
        val productData = loadProducts()

        val productAdapter = ProductRecyclerVIeAdapter(this, productData, fun (product: Product) {
            val productDetail = Intent(this, ProductDetail::class.java)
            productDetail.putExtra("productName", product.Name)
            productDetail.putExtra("productDescription", product.Description)
            productDetail.putExtra("productValue", product.Value)

            startActivity(productDetail)
        })

        recyclerView.adapter = productAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()
    }
}

fun loadProducts(): ArrayList<Product> {
    val productData = ArrayList<Product>()

    productData.add(Product("Xiaomi Redmi Note 9", "Smartphone 6 GB ram", 1990.10))
    productData.add(Product("Xiaomi Redmi Note 9 Pro", "Versão pro do smartphone da Xiaomi", 2350.20))
    productData.add(Product("Samsung Galaxy S20", "Smartphone de última geração da Samsung", 5520.30))
    productData.add(Product("Alexa Echo Dot 3", "Assistente doméstica", 290.90))
    productData.add(Product("Alexa Show 5", "Assistente doméstica com ecrã touch", 520.99))
    productData.add(Product("Google Chromecast", "Assistente doméstica da Google", 350.00))
    productData.add(Product("Xiaomi Stick", "Android TV portátil", 289.90))
    productData.add(Product("TV QLed 50 polegadas", "Televisão 4k", 2559.99))
    productData.add(Product("Playstation 5", "Console e manete", 4850.00))
    productData.add(Product("X-Box One X", "Console e duas manetes", 5250.00))
    productData.add(Product("iPhone 12", "iPhone Apple com 128GB de memória", 6570.00))
    productData.add(Product("JBL 2", "Caixa de som a prova d'água", 850.00))

    return productData
}