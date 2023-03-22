package com.khenao.notas.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khenao.notas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var MainActivityBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = MainActivityBinding.root
        setContentView(view)
        MainActivityBinding.calculateActionButton.setOnClickListener {
            val valueNoteOne = MainActivityBinding.enterNoteOneEditText.text.toString().toDouble()
            val valueNoteTwo = MainActivityBinding.enterNoteTwoEditText.text.toString().toDouble()
            val valueNoteThree = MainActivityBinding.enterNoteTrheeEditText.text.toString().toDouble()
            val valueNoteFour = MainActivityBinding.enterNoteFourEditText.text.toString().toDouble()
            val total = valueNoteOne*0.6 +  valueNoteTwo*0.07 + valueNoteThree*0.08 + valueNoteFour*0.25

            MainActivityBinding.finalGradeTextView.text = total.toString()



        }













    }
}