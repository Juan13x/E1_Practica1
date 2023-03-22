package com.khenao.notas.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityModel : ViewModel(){
    private val gradeMutableLiveData: MutableLiveData<Double> = MutableLiveData()
    val gradeLiveData: LiveData<Double> = gradeMutableLiveData
    private val errorMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val errorLiveData: LiveData<Boolean> = errorMutableLiveData

    fun calculateGrade(valueGradeOne: String, valueGradeTwo: String, valueGradeThree: String, valueGradeFour: String) {
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
            gradeMutableLiveData.value = gradeOne * 0.6 + gradeTwo * 0.07 + gradeThree * 0.08 + gradeFour * 0.25
        } else {
            errorMutableLiveData.value = true
        }
    }

}