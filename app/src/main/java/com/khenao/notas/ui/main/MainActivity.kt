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
            val valueGradeOne = MainActivityBinding.enterGradeOneEditText.text.toString().toDouble()
            val valueGradeTwo = MainActivityBinding.enterGradeTwoEditText.text.toString().toDouble()
            val valueGradeThree = MainActivityBinding.enterGradeTrheeEditText.text.toString().toDouble()
            val valueGradeFour = MainActivityBinding.enterGradeFourEditText.text.toString().toDouble()
            mainActivityModel.CalculateGrade(valueGradeOne, valueGradeTwo, valueGradeThree, valueGradeFour)

        }

        mainActivityModel.gradeLiveData.observe(this@MainActivity){gradeLiveData->
            MainActivityBinding.finalGradeTextView.text = gradeLiveData.toString()

        }
    }
}