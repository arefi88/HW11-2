package com.example.geoquiz

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CheatViewModel : ViewModel() {
    val answer:MutableLiveData<String> = MutableLiveData()

    fun updateAnswer(str:String){
        answer.value=str
    }
}