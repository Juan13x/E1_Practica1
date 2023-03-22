package com.khenao.notas.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.khenao.notas.R
import com.khenao.notas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityBinding : ActivityMainBinding
    private lateinit var mainActivityModel: MainActivityModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainActivityBinding.root
        setContentView(view)

        mainActivityModel = ViewModelProvider(this)[MainActivityModel::class.java]

        with(mainActivityBinding){
            calculateActionButton.setOnClickListener {
                val valueGradeOne = enterGradeOneEditText.text.toString()
                val valueGradeTwo = enterGradeTwoEditText.text.toString()
                val valueGradeThree = enterGradeTrheeEditText.text.toString()
                val valueGradeFour = enterGradeFourEditText.text.toString()

                mainActivityModel.calculateGrade(valueGradeOne, valueGradeTwo, valueGradeThree, valueGradeFour)
            }

            mainActivityModel.errorLiveData.observe(this@MainActivity) {
                Toast.makeText(this@MainActivity, R.string.error, Toast.LENGTH_SHORT).show()
            }

            mainActivityModel.gradeLiveData.observe(this@MainActivity){grade->
                mainActivityBinding.finalGradeTextView.text = grade.toString()
            }
        }
    }
}