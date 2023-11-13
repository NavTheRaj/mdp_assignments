package com.example.assignment2


import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private lateinit var radioGroupOne: RadioGroup;
    private lateinit var radioButtonOneA: RadioButton
    private lateinit var radioButtonOneB: RadioButton
    private lateinit var radioButtonOneC: RadioButton
    private lateinit var radioButtonOneD: RadioButton

    private lateinit var checkbox1: CheckBox
    private lateinit var checkbox2: CheckBox
    private lateinit var checkbox3: CheckBox
    private lateinit var checkbox4: CheckBox
    private lateinit var checkbox5: CheckBox

    private lateinit var submitBtn: Button
    private lateinit var resetBtn: Button

    private var score = 0
    private var checkboxScore = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        radioGroupOne = findViewById(R.id.radioGroupOne);
        radioButtonOneA = findViewById(R.id.radioButtonOneA)
        radioButtonOneB = findViewById(R.id.radioButtonOneB)
        radioButtonOneC = findViewById(R.id.radioButtonOneC)
        radioButtonOneD = findViewById(R.id.radioButtonOneD)

        checkbox1 = findViewById(R.id.checkbox1)
        checkbox2 = findViewById(R.id.checkbox2)
        checkbox3 = findViewById(R.id.checkbox3)
        checkbox4 = findViewById(R.id.checkbox4)
        checkbox5 = findViewById(R.id.checkbox5)

        submitBtn = findViewById(R.id.submitBtn)
        resetBtn = findViewById(R.id.resetBtn)

        // Set up the radio group
        radioGroupOne.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == radioButtonOneA.id) {
                // Correct answer
                score += 50
            }
        }


        fun calculateCheckBoxScore(isChecked: Boolean) {
            if (checkboxScore == 4 && isChecked) {
                score += 50
            } else if (checkboxScore == 5 && !isChecked) {
                score -= 50
            }

            checkboxScore = if (isChecked) checkboxScore + 1 else checkboxScore - 1
        }

        fun resetQuiz() {
            radioGroupOne.clearCheck()
            checkbox1.isChecked = false
            checkbox2.isChecked = false
            checkbox3.isChecked = false
            checkbox4.isChecked = false
            checkbox5.isChecked = false

            score = 0
        }

        // Set up the check boxes
        checkbox1.setOnCheckedChangeListener { _, isChecked ->
            calculateCheckBoxScore(isChecked)
        }
        checkbox2.setOnCheckedChangeListener { _, isChecked ->
            calculateCheckBoxScore(isChecked)
        }
        checkbox3.setOnCheckedChangeListener { _, isChecked ->
            calculateCheckBoxScore(isChecked)
        }
        checkbox4.setOnCheckedChangeListener { _, isChecked ->
            calculateCheckBoxScore(isChecked)
        }
        checkbox5.setOnCheckedChangeListener { _, isChecked ->
            calculateCheckBoxScore(isChecked)
        }

        // Set up the submit button
        submitBtn.setOnClickListener {
            // Check the answers

            // Show an alert dialog with the results
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Quiz Results")
            builder.setMessage("You scored $score points.")
            builder.setPositiveButton("OK") { dialog, _ ->
                resetQuiz()
                dialog.dismiss()
            }
            builder.show()
        }

        // Set up the reset button
        resetBtn.setOnClickListener {
            // Clear the answers and reset the score
            resetQuiz()
        }


    }
}
