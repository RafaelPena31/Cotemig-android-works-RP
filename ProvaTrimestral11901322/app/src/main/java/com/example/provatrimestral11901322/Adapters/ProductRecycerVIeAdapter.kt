package com.example.provatrimestral11901322.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.provatrimestral11901322.Classes.Product
import com.example.provatrimestral11901322.R
import java.util.*

class ProductRecyclerVIeAdapter (private val context: Context, private val lista: ArrayList<Product>,
                                var itemClickLister: (product: Product) -> Unit) :
    RecyclerView.Adapter<ProductRecyclerVIeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_cell, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = lista[position]
        holder.nameTV.text = product.Name
        holder.descriptionTV.text = product.Description
        holder.priceTV.text = "Valor: R$ ${product.Value}"

        holder.itemView.setOnClickListener {
            itemClickLister(product)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTV = view.findViewById<TextView>(R.id.nameTV)
        val descriptionTV = view.findViewById<TextView>(R.id.descriptionTV)
        val priceTV = view.findViewById<TextView>(R.id.priceTV)
    }
}