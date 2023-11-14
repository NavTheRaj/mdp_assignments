package com.example.assignment2

import java.io.Serializable

data class Product(
    val productName: String, val cost: String, val image: Int, val itemId: Long,
    val desc: String,
    val brandLogo:Int
) : Serializable