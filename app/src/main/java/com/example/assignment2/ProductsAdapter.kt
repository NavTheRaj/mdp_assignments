package com.example.assignment2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(private val context: Context, private val products: List<Product>) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]

        holder.imageView.setImageResource(product.image)
        holder.titleTextView.text = product.productName
        holder.priceTextView.text = product.cost
        holder.descriptionTextView.text = product.desc

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ElectronicDetailActivity::class.java)
            intent.putExtra("product", product)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imgProduct)
        val titleTextView: TextView = itemView.findViewById(R.id.tvTitle)
        val priceTextView: TextView = itemView.findViewById(R.id.tvPrice)
        val descriptionTextView: TextView = itemView.findViewById(R.id.tvDesc)
    }
}
