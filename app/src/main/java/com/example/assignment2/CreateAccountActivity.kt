package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText;
    private lateinit var signUpBtn: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.assignment2.R.layout.activity_create_account);
        firstName = findViewById(R.id.firstNameText)
        lastName = findViewById(R.id.lastNameText)
        email = findViewById(R.id.emailText);
        password = findViewById(R.id.passwordText);
        signUpBtn = findViewById(R.id.createAccountBtn)

        signUpBtn.setOnClickListener{
            if (validateDetails()) {
                val newUser = User(
                    firstName.text.toString(),
                    lastName.text.toString(),
                    email.text.toString(),
                    password.text.toString()
                );
                UsersList.addUser(
                   newUser
                )
                Toast.makeText(this, "Created Account", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("firstName", firstName.text.toString())
                intent.putExtra("lastName", lastName.text.toString())
                intent.putExtra("email", email.text.toString())
                intent.putExtra("password", password.text.toString())


                startActivity(intent);
            } else {
                Toast.makeText(
                    this,
                    "Empty fields, please fill all correctly",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    fun validateDetails(): Boolean {
        if (firstName.toString().isNullOrEmpty() || lastName.toString().isNullOrEmpty()
            ||
            email.toString().isNullOrEmpty()
            ||
            password.toString().isNullOrEmpty()
        ) {
            return false
        }
        return true
    }
//
    private val clickListener: View.OnClickListener = View.OnClickListener { view ->
        run {
            when (view.id) {
                com.example.assignment2.R.id.signInBtn -> {



                }

            }
        }
    }
}