package com.example.geoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity() {
    private lateinit var constraint: ConstraintLayout
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnCheat: Button
    private lateinit var btnNext: Button
    private lateinit var btnPrev: Button
    private lateinit var txtQuestion: TextView
    private lateinit var ac: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //init()
        ac = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val cheatMessage = it.data?.getStringExtra("CHEAT")
                Toast.makeText(this, cheatMessage, Toast.LENGTH_SHORT).show()
            }
        }
//        supportFragmentManager.commit {
//            setReorderingAllowed(true)
//            replace<QuizFragment>(R.id.container)
//           // addToBackStack(null)
//            super.onResume()
//        }
//        val question = Question()
//        val list = question.getQuestions()
//        txtQuestion.text = list[0]
//        var counter = 0
//        btnNext.setOnClickListener {
//            btnPrev.isEnabled = true
//            counter++
//            btnNext.isEnabled = counter != 9
//            txtQuestion.text = list[counter]
//
//        }
//        btnPrev.setOnClickListener {
//            btnNext.isEnabled = true
//            counter--
//            if (counter < 0) {
//                btnPrev.isEnabled = false
//                counter = 0
//                return@setOnClickListener
//            }
//            btnPrev.isEnabled = counter != 0
//
//            txtQuestion.text = list[counter]
//
//
//        }
//        btnTrue.setOnClickListener {
//            if (counter == 0 || counter == 2 || counter == 4 || counter == 5
//                || counter == 7 || counter == 9
//            ) {
//                Toast.makeText(this, "correct!", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(this, "incorrect!", Toast.LENGTH_SHORT).show()
//            }
//
//        }
//        btnFalse.setOnClickListener {
//            if (counter == 1 || counter == 3 || counter == 6 || counter == 8) {
//                Toast.makeText(this, "correct!", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(this, "incorrect!", Toast.LENGTH_SHORT).show()
//            }
//        }
//        btnCheat.setOnClickListener {
//            supportFragmentManager.commit {
//                val bundle = Bundle()
//                val fragment = CheatFragment()
//                bundle.putString("QUESTION", txtQuestion.text.toString())
//                bundle.putInt("COUNTER", counter)
//                fragment.arguments = bundle
//                setReorderingAllowed(true)
//                add(R.id.container, fragment)
//                addToBackStack(null)
//
//            }
////            ac.launch(
////                CheatActivity.newIntent(
////                    this@MainActivity,
////                    counter,
////                    txtQuestion.text.toString()
////                )
////            )
//        }
//    }
    }
//        override fun onResume() {
//            supportFragmentManager.commit {
//                setReorderingAllowed(true)
//                replace<QuizFragment>(R.id.container)
//               // addToBackStack(null)
//                super.onResume()
//            }
//        }

        private fun init() {
            btnTrue = findViewById(R.id.btnTrue)
            btnFalse = findViewById(R.id.btnFalse)
            btnCheat = findViewById(R.id.btnCheat)
            btnNext = findViewById(R.id.btnNext)
            btnPrev = findViewById(R.id.btnPrev)
            txtQuestion = findViewById(R.id.txtQuestion)
            constraint = findViewById(R.id.constraint)
        }



}