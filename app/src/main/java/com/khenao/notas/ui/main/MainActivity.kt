package com.khenao.notas.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.khenao.notas.R
import com.khenao.notas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainActivityBinding.root
        setContentView(view)

        with(mainActivityBinding) {

            calculateActionButton.setOnClickListener {
                val valueGradeOne = enterGradeOneEditText.text.toString()
                val valueGradeTwo = enterGradeTwoEditText.text.toString()
                val valueGradeThree = enterGradeTrheeEditText.text.toString()
                val valueGradeFour = enterGradeFourEditText.text.toString()

                if (
                    valueGradeOne.isNotEmpty()
                    and valueGradeTwo.isNotEmpty()
                    and valueGradeThree.isNotEmpty()
                    and valueGradeFour.isNotEmpty()
                ) {
                    val gradeOne = valueGradeOne.toDouble()
                    val gradeTwo = valueGradeTwo.toDouble()
                    val gradeThree = valueGradeThree.toDouble()
                    val gradeFour = valueGradeFour.toDouble()
                    val total = gradeOne * 0.6 + gradeTwo * 0.07 + gradeThree * 0.08 + gradeFour * 0.25
                    finalGradeTextView.text = total.toString()
                } else {
                    Toast.makeText(this@MainActivity, R.string.error, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}