package com.example.assignment2

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ShoppingActivity : AppCompatActivity() {

    lateinit var electronImage: ImageView;
    lateinit var beautyImage: ImageView;
    lateinit var clothingImage: ImageView;
    lateinit var dietImage: ImageView;
    lateinit var profile:TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.assignment2.R.layout.shopping_activity)

        electronImage = findViewById(com.example.assignment2.R.id.tv);
        beautyImage = findViewById(com.example.assignment2.R.id.beauty);
        clothingImage = findViewById(com.example.assignment2.R.id.clothing);
        dietImage = findViewById(com.example.assignment2.R.id.diet);
        profile = findViewById(com.example.assignment2.R.id.profile)
        electronImage.setOnClickListener(clickListener);
        beautyImage.setOnClickListener(clickListener);
        clothingImage.setOnClickListener(clickListener);
        dietImage.setOnClickListener(clickListener);

        val username = getIntent().getStringExtra("username")
        profile.setText(username.toString());
    }

    val clickListener: View.OnClickListener = View.OnClickListener { view ->
        run {
            when (view.id) {
                com.example.assignment2.R.id.tv -> {
                    Toast.makeText(this, "Electronics Category", Toast.LENGTH_SHORT).show()
                }

                com.example.assignment2.R.id.beauty -> {
                    Toast.makeText(this, "Beauty Category", Toast.LENGTH_SHORT).show()
                }

                com.example.assignment2.R.id.clothing -> {
                    Toast.makeText(this, "Clothing Category", Toast.LENGTH_SHORT).show()
                }

                com.example.assignment2.R.id.diet -> {
                    Toast.makeText(this, "Diets Category", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}