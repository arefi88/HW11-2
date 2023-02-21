package com.example.geoquiz

class Question {
    var listQuestion= mutableListOf<String>()
    var listQuestion2= hashMapOf<String,Boolean>()

    fun getQuestion():HashMap<String,Boolean>{
        listQuestion2["Berlin is the capital Germany"] = true
        listQuestion2["NewYork is the capital USA"] = false
        listQuestion2["Baghdad is the capital Iraq"] = true
        listQuestion2["mashhad is the capital India"] = false
        listQuestion2["Moscow is the capital Russia"] = true
        listQuestion2["Tehran is the capital Iran"] = true
        listQuestion2["Canberra is the capital Hungary"] = false
        listQuestion2["Paris is the capital France"] = true
        listQuestion2["Manchester is the capital English"] = false
        listQuestion2["Ankara is the capital Turkey"] = true
        return listQuestion2
    }
    fun getQuestions():List<String> {
        listQuestion.add("Berlin is the capital Germany?")
        listQuestion.add("NewYork is the capital USA?")
        listQuestion.add("Baghdad is the capital Iraq?")
        listQuestion.add("mashhad is the capital India?")
        listQuestion.add("Moscow is the capital Russia?")
        listQuestion.add("Tehran is the capital Iran?")
        listQuestion.add("Canberra is the capital Hungary?")
        listQuestion.add("Paris is the capital France?")
        listQuestion.add("Manchester is the capital English?")
        listQuestion.add("Ankara is the capital Turkey?")
        return listQuestion
    }

}