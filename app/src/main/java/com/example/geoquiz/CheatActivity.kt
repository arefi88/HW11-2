package com.example.geoquiz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class CheatActivity : AppCompatActivity() {
    private lateinit var btnAnswer:Button
    private lateinit var txtAnswer:TextView
    private lateinit var txtQuestion:TextView
    private lateinit var viewModel:CheatViewModel
    companion object {
        private val counterTag: String by lazy {
           CheatActivity::class.java.name + "counter"
        }
        private val textTag: String by lazy {
            CheatActivity::class.java.name + "text"
        }

        fun newIntent(context: Context, counter: Int?,text: String?): Intent {
            return Intent(context,CheatActivity::class.java).apply {
                putExtra(counterTag,counter)
                putExtra(textTag,text)

            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)
        viewModel= ViewModelProvider(this)[CheatViewModel::class.java]
        viewModel.answer.observe(this, Observer {
            txtAnswer.text=it.toString()
        })
        txtQuestion=findViewById(R.id.txtQuestion)
        btnAnswer=findViewById(R.id.btnAnswer)
        txtAnswer=findViewById(R.id.txtAnswer)
       txtQuestion.text=intent.getStringExtra(textTag)
       val counter=intent.getIntExtra(counterTag,-1)

        btnAnswer.setOnClickListener {
            if (counter==0 || counter==2 || counter==4 || counter==5
                ||counter==7 || counter==9){
                txtAnswer.text="true"
                viewModel.updateAnswer(txtAnswer.text.toString())
            }else{
                txtAnswer.text="false"
                viewModel.updateAnswer(txtAnswer.text.toString())
            }
        }

        onBackPressedDispatcher.addCallback(this,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {

                setResult(RESULT_OK,Intent().apply {
            putExtra("CHEAT","Cheating is wrong") })
                //remove()
                finish()
            }

        })
    }


//    @Deprecated("Deprecated in Java")
//    override fun onBackPressed() {
//
//        setResult(RESULT_OK,Intent().apply {
//            putExtra("CHEAT","Cheating is wrong")
//        })
//
//        super.onBackPressed()
//
//    }


}