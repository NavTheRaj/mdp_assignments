package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private val menuList =
        arrayListOf<String>("Hamburger", "Pizza", "Mexican", "American", "Chinese");
//    val decideButton: Button = findViewById(R.id.decide_button);
//    val editable_text: EditText = this.findViewById(R.id.menu_editable);
//    val addButton: Button = findViewById(R.id.add_button);

    lateinit var addButton: Button;
    lateinit var decideButton: Button;
    lateinit var menuText: EditText;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        menuText = findViewById(R.id.menu_editable)
        addButton = findViewById(R.id.add_button)
        decideButton = findViewById(R.id.decide_button)
        addButton.setOnClickListener(clickListener);
        decideButton.setOnClickListener(clickListener)
    }

    fun alertUser(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Dinner Message")
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which ->
            dialog.dismiss();
        }
        val dialog = builder.create()
        dialog.show()

    }

    val clickListener: View.OnClickListener = View.OnClickListener { view ->
        run {
            when (view.id) {
                R.id.add_button -> {
                    val toAdd = menuText.text;
                    if(toAdd.toString().isNotEmpty()){
                        menuList.add(toAdd.toString())
                        toAdd.clear();
                        alertUser("Added a new menu!")

                    }else{
                        alertUser("Please enter a valid menu!")
                    }
                }

                R.id.decide_button -> {
                    menuText.setText(menuList[Random.nextInt(menuList.size)])
                }
            }
        }
    }

}


