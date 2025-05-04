package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

class CalculatorActivity : ComponentActivity() {

    lateinit var backButton: Button
    lateinit var number1InputBox: EditText
    lateinit var number2InputBox: EditText
    lateinit var resultButton: Button
    lateinit var addButton: Button
    lateinit var subButton: Button
    lateinit var mulButton: Button
    lateinit var divButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_activity)

        backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            startActivity(Intent(this@CalculatorActivity, MainActivity::class.java))
        }

        number1InputBox = findViewById<EditText>(R.id.number1)
        number2InputBox = findViewById<EditText>(R.id.number2)

        resultButton = findViewById<Button>(R.id.resultButton)
        resultButton.isClickable = false

        addButton = findViewById<Button>(R.id.addButton)
        subButton = findViewById<Button>(R.id.subButton)
        mulButton = findViewById<Button>(R.id.mulButton)
        divButton = findViewById<Button>(R.id.divButton)


        addButton.setOnClickListener {
            calculate(addButton, number1InputBox, number2InputBox, resultButton)
        }

        subButton.setOnClickListener {
            calculate(subButton, number1InputBox, number2InputBox, resultButton)
        }

        mulButton.setOnClickListener {
            calculate(mulButton, number1InputBox, number2InputBox, resultButton)
        }

        divButton.setOnClickListener {
            calculate(divButton, number1InputBox, number2InputBox, resultButton)
        }

    }

    fun calculate(whichButton: Button, view1: EditText, view2: EditText, resultBtn: Button) {
        val num1: Float
        val num2: Float
        val result: Float

        if (view1.text.toString().isEmpty()) {
            view1.error = "Please enter a number"
            return
        } else {
            num1 = view1.text.toString().toFloat()
        }

        if (view2.text.toString().isEmpty()) {
            view2.error = "Please enter a number"
            return
        } else {
            num2 = view2.text.toString().toFloat()
        }

        when (whichButton.id) {
            R.id.addButton -> {
                result = num1 + num2
                resultBtn.text = result.toString()
            }

            R.id.subButton -> {
                result = num1 - num2
                resultBtn.text = result.toString()
            }

            R.id.mulButton -> {
                result = num1 * num2
                resultBtn.text = result.toString()
            }

            R.id.divButton -> {
                if (num2 == 0f) {
                    view2.error = "This number can't be zero"
                    return
                } else {
                    result = num1 / num2
                }
                resultBtn.text = result.toString()
            }
        }

    }

}
