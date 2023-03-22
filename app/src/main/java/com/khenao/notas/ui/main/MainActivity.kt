package com.khenao.notas.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.khenao.notas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var MainActivityBinding : ActivityMainBinding
    private lateinit var mainActivityModel: MainActivityModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = MainActivityBinding.root
        setContentView(view)

        mainActivityModel = ViewModelProvider(this)[MainActivityModel::class.java]

        MainActivityBinding.calculateActionButton.setOnClickListener {
            val valueNoteOne = MainActivityBinding.enterNoteOneEditText.text.toString().toDouble()
            val valueNoteTwo = MainActivityBinding.enterNoteTwoEditText.text.toString().toDouble()
            val valueNoteThree = MainActivityBinding.enterNoteTrheeEditText.text.toString().toDouble()
            val valueNoteFour = MainActivityBinding.enterNoteFourEditText.text.toString().toDouble()
            mainActivityModel.CalculateGrade(valueNoteOne, valueNoteTwo, valueNoteThree, valueNoteFour)

        }

        mainActivityModel.gradeLiveData.observe(this@MainActivity){gradeLiveData->
            MainActivityBinding.finalGradeTextView.text = gradeLiveData.toString()

        }
    }
}