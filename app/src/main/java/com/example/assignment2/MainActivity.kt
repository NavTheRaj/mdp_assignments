package com.example.assignment2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var addButton: Button;
    lateinit var tablePanel: TableLayout;
    lateinit var versionName: EditText;
    lateinit var codeName: EditText;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addButton = findViewById(R.id.add_button)
        addButton.setOnClickListener(clickListener);
        tablePanel = findViewById(R.id.tab_panel)
        versionName = findViewById(R.id.edit_android_version);
        codeName = findViewById(R.id.edit_android_code_name);
    }

    fun alertUser(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Tab Message")
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which ->
            dialog.dismiss();
        }
        val dialog = builder.create()
        dialog.show()

    }

    fun addRowWithValue(code: String, version: String) {
        val tableRow = TableRow(this)

        val androidVersionTextView = TextView(this)
        androidVersionTextView.setText(version)

        val androidCodeNameTextView = TextView(this)
        androidCodeNameTextView.setText(code)

        tableRow.addView(androidVersionTextView)
        tableRow.addView(androidCodeNameTextView)



        tablePanel.addView(tableRow)
    }

    val clickListener: View.OnClickListener = View.OnClickListener { view ->
        run {
            when (view.id) {
                R.id.add_button -> {
                    val codeToAdd = codeName.text;
                    val versionToAdd = versionName.text;

                   if(codeToAdd.toString().isNullOrEmpty() || versionToAdd.toString().isNullOrEmpty()){
                       alertUser("Please enter the values!")
                   }

                    if (codeToAdd.toString().isNotEmpty() && versionToAdd.toString().isNotEmpty()) {
                        println(codeToAdd)
                        addRowWithValue(codeToAdd.toString(), versionToAdd.toString());
                        codeToAdd.clear();
                        versionToAdd.clear();
                        alertUser("Added a new android!")
                    }
                }
            }
        }
    }
}


