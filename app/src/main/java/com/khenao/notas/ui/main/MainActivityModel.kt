package com.khenao.notas.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityModel : ViewModel(){
    private val gradeMutableLiveData: MutableLiveData<Double> = MutableLiveData()
    val gradeLiveData: LiveData<Double> = gradeMutableLiveData

    fun CalculateGrade(
        valueGradeOne: Double,
        valueGradeTwo: Double,
        valueGradeThree: Double,
        valueGradeFour: Double
    ) {
        gradeMutableLiveData.value = valueGradeOne * 0.6 + valueGradeTwo * 0.07 + valueGradeThree * 0.08 + valueGradeFour * 0.25
    }

}