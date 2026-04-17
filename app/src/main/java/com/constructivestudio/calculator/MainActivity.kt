package com.constructivestudio.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val process = findViewById<TextView>(R.id.process)
        val answer = findViewById<TextView>(R.id.answer)
        val one = findViewById<Button>(R.id.oneButton)
        val two = findViewById<Button>(R.id.twoButton)
        val three = findViewById<Button>(R.id.threeButton)
        val four = findViewById<Button>(R.id.fourButton)
        val five = findViewById<Button>(R.id.fiveButton)
        val six = findViewById<Button>(R.id.sixButton)
        val seven = findViewById<Button>(R.id.sevenButton)
        val eight = findViewById<Button>(R.id.eightButton)
        val nine = findViewById<Button>(R.id.nineButton)
        val zero = findViewById<Button>(R.id.zeroButton)
        val plus = findViewById<Button>(R.id.plusButton)
        val minus = findViewById<Button>(R.id.minButton)
        val mul = findViewById<Button>(R.id.mulButton)
        val div = findViewById<Button>(R.id.divButton)
        val equals = findViewById<Button>(R.id.equalsButton)
        val dot = findViewById<Button>(R.id.dotsButton)
        val ac = findViewById<Button>(R.id.acButton)

        process.text = ""
        answer.text = ""

        one.setOnClickListener { process.append("1") }
        two.setOnClickListener { process.append("2") }
        three.setOnClickListener { process.append("3") }
        four.setOnClickListener { process.append("4") }
        five.setOnClickListener { process.append("5") }
        six.setOnClickListener { process.append("6") }
        seven.setOnClickListener { process.append("7") }
        eight.setOnClickListener { process.append("8") }
        nine.setOnClickListener { process.append("9") }
        zero.setOnClickListener { process.append("0") }
        plus.setOnClickListener { process.append("+") }
        minus.setOnClickListener { process.append("-") }
        div.setOnClickListener { process.append("÷") }
        mul.setOnClickListener { process.append("×") }
        dot.setOnClickListener { process.append(".") }
        equals.setOnClickListener {
            val expression = process.text.toString()

            if (process.text.toString().contains("+")) {
                val before = expression.substringBefore("+")
                val after = expression.substringAfter("+")

                val firstNumber = before.toFloatOrNull()
                val secondNumber = after.toFloatOrNull()

                if (firstNumber == null || secondNumber == null) {
                    answer.text = "Введите числа"
                }
                else {
                    val getAnswer = firstNumber + secondNumber
                    answer.text = getAnswer.toString()
                }
            }

            if (process.text.toString().contains("-")) {
                val before = expression.substringBefore("-")
                val after = expression.substringAfter("-")

                val firstNumber = before.toFloatOrNull()
                val secondNumber = after.toFloatOrNull()

                if (firstNumber == null || secondNumber == null) {
                    answer.text = "Введите числа"
                }
                else {
                    val getAnswer = firstNumber - secondNumber
                    answer.text = getAnswer.toString()
                }

            }

            if (process.text.toString().contains("×")) {
                val before = expression.substringBefore("×")
                val after = expression.substringAfter("×")

                val firstNumber = before.toFloatOrNull()
                val secondNumber = after.toFloatOrNull()

                if (firstNumber == null || secondNumber == null) {
                    answer.text = "Введите числа"
                }
                else {
                    val getAnswer = firstNumber * secondNumber
                    answer.text = getAnswer.toString()
                }
            }

            if (process.text.toString().contains("÷")) {
                val before = expression.substringBefore("÷")
                val after = expression.substringAfter("÷")

                val firstNumber = before.toFloatOrNull()
                val secondNumber = after.toFloatOrNull()

                    if (firstNumber == null || secondNumber == null) {
                        answer.text = "Введите числа"
                    }
                    else {
                        if (secondNumber.toInt() == 0) {
                            answer.text = "Делить на 0 нельзя"
                        }
                        else {
                            val getAnswer = firstNumber / secondNumber
                            answer.text = getAnswer.toString()
                    }
                }
            }
        }
        ac.setOnClickListener {
            process.text = ""
            answer.text = ""
        }
    }
}