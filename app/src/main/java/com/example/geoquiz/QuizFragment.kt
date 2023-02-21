package com.example.geoquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.example.geoquiz.databinding.FragmentQuizBinding

class QuizFragment : Fragment(R.layout.fragment_quiz) {
    lateinit var binding : FragmentQuizBinding
    private val quizViewMode: QuizFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentQuizBinding.bind(view)
        binding.viewModel=quizViewMode
        val question = Question()
        val list = question.getQuestions()
        binding.txtQuestion.text = list[quizViewMode.counter.value!!]
        //var counter = 0
        //quizViewMode.counter.value=0
        quizViewMode.counter.observe(viewLifecycleOwner){
            binding.txtQuestion.text = list[it]
        }
        binding.btnNext.setOnClickListener {
            binding.btnPrev.isEnabled = true
           // counter++
            quizViewMode.counter.value= quizViewMode.counter.value!!.plus(1)
            binding.btnNext.isEnabled = quizViewMode.counter.value != 9
            binding.txtQuestion.text = list[quizViewMode.counter.value!!]

        }
        binding.btnPrev.setOnClickListener {
            binding.btnNext.isEnabled = true
            //counter--
            quizViewMode.counter.value= quizViewMode.counter.value!!.minus(1)
            if (quizViewMode.counter.value!! < 0) {
                binding.btnPrev.isEnabled = false
                quizViewMode.counter.value = 0
                return@setOnClickListener
            }
            binding.btnPrev.isEnabled = quizViewMode.counter.value != 0

            binding.txtQuestion.text = list[quizViewMode.counter.value!!]


        }
        binding.btnTrue.setOnClickListener {
            if (quizViewMode.counter.value!! == 0 || quizViewMode.counter.value!! == 2 || quizViewMode.counter.value!! == 4 || quizViewMode.counter.value!! == 5
                || quizViewMode.counter.value!! == 7 || quizViewMode.counter.value!! == 9) {
                Toast.makeText(activity, "correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "incorrect!", Toast.LENGTH_SHORT).show()
            }

        }
        binding.btnFalse.setOnClickListener {
            if (quizViewMode.counter.value!! == 1 || quizViewMode.counter.value!! == 3 || quizViewMode.counter.value!! == 6 || quizViewMode.counter.value!! == 8) {
               Toast.makeText(activity, "correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "incorrect!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnCheat.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                val bundle = Bundle()
                val fragment = CheatFragment()
                bundle.putString("QUESTION", binding.txtQuestion.text.toString())
                bundle.putInt("COUNTER", quizViewMode.counter.value!!)
                fragment.arguments = bundle
                setReorderingAllowed(true)
                replace(R.id.container, fragment)
                addToBackStack(null)
            }
        }
    }

    override fun onResume() {
        if (quizViewMode.counter.value==0){
            binding.btnPrev.isEnabled=false
        }else if (quizViewMode.counter.value==9){
            binding.btnNext.isEnabled=false
        }
        super.onResume()
    }


}