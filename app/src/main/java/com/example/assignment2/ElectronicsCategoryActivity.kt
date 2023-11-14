package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ElectronicsCategoryActivity : AppCompatActivity() {
    private val productList = mutableListOf<Product>(
        Product("Dell \" Laptop", "$500", R.drawable.dell, 1L, "Dell Laptop",R.drawable.dell),
        Product("Macbook\" Laptop", "$699", R.drawable.macbook, 2L, "Macbook Laptop New Refurbished",R.drawable.applelogo),
        Product("Pixel 8\" Pro", "$499", R.drawable.pixel, 3L, "Pixel 8 Pro Unlocked",R.drawable.pixel),
        Product("Lenovo\" Ideapad", "$599", R.drawable.lenovo, 4L, "Lenovo Ideepad with newon keywords",R.drawable.lenovo)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_electronics_category)

        val rvProductList = findViewById<RecyclerView>(R.id.rvProductList)
        rvProductList.layoutManager = LinearLayoutManager(this)
        val adapter = ProductsAdapter(this,productList )
        rvProductList.adapter = adapter
    }
}