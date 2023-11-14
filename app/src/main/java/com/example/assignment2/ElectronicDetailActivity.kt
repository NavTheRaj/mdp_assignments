package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ElectronicDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electronic_detail)
        val intentData = intent.getSerializableExtra("product")
        val product = intentData as Product

        val imgProductImage = findViewById<ImageView>(R.id.imgProductImage)
        val tvProductTitle = findViewById<TextView>(R.id.tvProductTitle)
        val tvProductNumber = findViewById<TextView>(R.id.tvProductNumber)
        val tvProductDesc = findViewById<TextView>(R.id.tvProductDesc)

        product?.image?.let { imgProductImage.setBackgroundResource(it) }
        tvProductTitle.text = product?.productName
        tvProductNumber.text = "Item: ${product?.itemId.toString()}"
        tvProductDesc.text = "Item Description:\n${product?.desc}"
    }
}