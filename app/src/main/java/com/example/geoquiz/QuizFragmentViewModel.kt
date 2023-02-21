package com.example.geoquiz

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuizFragmentViewModel : ViewModel() {
    var counter=MutableLiveData<Int>(0)
}