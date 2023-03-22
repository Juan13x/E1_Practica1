package com.khenao.notas.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityModel : ViewModel(){
    private val gradeMutableLiveData: MutableLiveData<Double> = MutableLiveData()
    val gradeLiveData: LiveData<Double> = gradeMutableLiveData

    fun CalculateGrade(
        valueNoteOne: Double,
        valueNoteTwo: Double,
        valueNoteThree: Double,
        valueNoteFour: Double
    ) {
        gradeMutableLiveData.value = valueNoteOne * 0.6 + valueNoteTwo * 0.07 + valueNoteThree * 0.08 + valueNoteFour * 0.25
    }

}