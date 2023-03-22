package com.khenao.notas.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khenao.notas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainActivityBinding.root
        setContentView(view)

        mainActivityBinding.calculateActionButton.setOnClickListener {
            val valueNoteOne = mainActivityBinding.enterNoteOneEditText.text.toString().toDouble()
            val valueNoteTwo = mainActivityBinding.enterNoteTwoEditText.text.toString().toDouble()
            val valueNoteThree = mainActivityBinding.enterNoteTrheeEditText.text.toString().toDouble()
            val valueNoteFour = mainActivityBinding.enterNoteFourEditText.text.toString().toDouble()
            val total = valueNoteOne*0.6 +  valueNoteTwo*0.07 + valueNoteThree*0.08 + valueNoteFour*0.25

            mainActivityBinding.finalGradeTextView.text = total.toString()
        }
    }
}