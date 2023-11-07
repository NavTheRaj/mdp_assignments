package com.example.assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var signInBtn: Button
    private lateinit var emailText: EditText
    private lateinit var passwordText: EditText
    private lateinit var createAccountBtn: Button
    private lateinit var forgotPass:TextView
    val users: ArrayList<User> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the views using view binding
        signInBtn = findViewById(R.id.signInBtn)
        emailText = findViewById(R.id.emailText)
        passwordText = findViewById(R.id.passwordText)
        createAccountBtn = findViewById(R.id.createAcntBtn);
        forgotPass = findViewById(R.id.forgotPassword);

        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val email = intent.getStringExtra("email")


        val password = intent.getStringExtra("password")

        users.add(User(firstName.toString(), lastName.toString(), email.toString(), password.toString()))
        users.add(User("John", "Doe", "john.doe@example.com", "password123"))
        users.add(User("Jane", "Doe", "jane.doe@example.com", "password456"))
        users.add(User("Peter", "Parker", "peter.parker@example.com", "spiderman"))
        users.add(User("Mary", "Jane", "mary.jane@example.com", "mj"))
        users.add(User("Bruce", "Wayne", "bruce.wayne@example.com", "batman"))

        UsersList.addUsers(users)


        // Set the click listener for the sign in button
        signInBtn.setOnClickListener {
            // Validate the login credentials
            val username = emailText.text.toString()
            val password = passwordText.text.toString()

            val user = UsersList.getUsers().find { it.username == username }


            if (user != null && user.password == password) {
                // Start the shopping activity
                val intent = Intent(this, ShoppingActivity::class.java)

                val user = UsersList.getUsers().find { it.username == username }
                val username = user?.firstName + " " + user?.lastName;

                intent.putExtra("username", username)
                startActivity(intent)
            } else {
                // Show an error message
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

        createAccountBtn.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }

        forgotPass.setOnClickListener {
            if(!emailText.toString().isNullOrEmpty() && !passwordText.toString().isNullOrEmpty()){
                sendEmail(emailText.toString());
            }else{
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun getPasswordFromList(email:String): String {
        val user = UsersList.getUsers().find { user -> user.username == email }
        if (user != null) {
            return user.password.toString()
        }

        return "No record found";
    }

    fun sendEmail(email:String){
        val password: String = getPasswordFromList(email)


        val emailIntent = Intent(Intent.ACTION_SEND)


        emailIntent.type = "message/rfc822"


        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))


        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Password Recovery")


        emailIntent.putExtra(Intent.EXTRA_TEXT, "Your password is: $password")


        startActivity(Intent.createChooser(emailIntent, "Send Email"))
    }
}

