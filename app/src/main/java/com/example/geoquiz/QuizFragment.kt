package com.example.geoquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.geoquiz.databinding.FragmentQuizBinding

class QuizFragment : Fragment(R.layout.fragment_quiz) {
    lateinit var binding : FragmentQuizBinding
    private val quizFragmentViewModel: QuizFragmentViewModel by viewModels()
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
        binding.viewModel=quizFragmentViewModel
        val question = Question()
        val list = question.getQuestions()
        binding.txtQuestion.text = list[quizFragmentViewModel.counter.value!!]

        quizFragmentViewModel.counter.observe(viewLifecycleOwner){
            binding.txtQuestion.text = list[it]
        }
        binding.btnNext.setOnClickListener {
            binding.btnPrev.isEnabled = true
            quizFragmentViewModel.isCheat.value=false
           // counter++
            quizFragmentViewModel.counter.value= quizFragmentViewModel.counter.value!!.plus(1)
            binding.btnNext.isEnabled = quizFragmentViewModel.counter.value != 9
            binding.txtQuestion.text = list[quizFragmentViewModel.counter.value!!]

        }
        binding.btnPrev.setOnClickListener {
            binding.btnNext.isEnabled = true
            quizFragmentViewModel.isCheat.value=false
            quizFragmentViewModel.counter.value= quizFragmentViewModel.counter.value!!.minus(1)
            if (quizFragmentViewModel.counter.value!! < 0) {
                binding.btnPrev.isEnabled = false
                quizFragmentViewModel.counter.value = 0
                return@setOnClickListener
            }
            binding.btnPrev.isEnabled = quizFragmentViewModel.counter.value != 0

            binding.txtQuestion.text = list[quizFragmentViewModel.counter.value!!]


        }
        quizFragmentViewModel.isCheat.observe(viewLifecycleOwner){
            if (it){
                binding.btnFalse.isEnabled=false
                binding.btnTrue.isEnabled=false
            }else{
                binding.btnFalse.isEnabled=true
                binding.btnTrue.isEnabled=true

            }
        }
        binding.btnTrue.setOnClickListener {
            if (quizFragmentViewModel.counter.value!! == 0 || quizFragmentViewModel.counter.value!! == 2 || quizFragmentViewModel.counter.value!! == 4 || quizFragmentViewModel.counter.value!! == 5
                || quizFragmentViewModel.counter.value!! == 7 || quizFragmentViewModel.counter.value!! == 9) {
                Toast.makeText(activity, "correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "incorrect!", Toast.LENGTH_SHORT).show()
            }

        }
        binding.btnFalse.setOnClickListener {
            if (quizFragmentViewModel.counter.value!! == 1 || quizFragmentViewModel.counter.value!! == 3 || quizFragmentViewModel.counter.value!! == 6 || quizFragmentViewModel.counter.value!! == 8) {
               Toast.makeText(activity, "correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "incorrect!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnCheat.setOnClickListener {

            quizFragmentViewModel.isCheat.value=true
            val action=QuizFragmentDirections.actionQuizFragmentToCheatFragment(quizFragmentViewModel.counter.value!!,
                                                                                binding.txtQuestion.text.toString())
            Navigation.findNavController(view).navigate(action)
        }
    }

    override fun onResume() {
        if (quizFragmentViewModel.counter.value==0){
            binding.btnPrev.isEnabled=false
        }else if (quizFragmentViewModel.counter.value==9){
            binding.btnNext.isEnabled=false
        }
        super.onResume()
    }


}