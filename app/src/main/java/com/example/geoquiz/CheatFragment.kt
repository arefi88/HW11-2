package com.example.geoquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.geoquiz.databinding.FragmentCheatBinding

class CheatFragment : Fragment(R.layout.fragment_cheat) {
    lateinit var binding : FragmentCheatBinding
    private val cheatViewModel:CheatViewModel by viewModels()
    val args: CheatFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentCheatBinding.bind(view)
        binding.viewModel=cheatViewModel
        val counter=args.counter
        binding.txtQuestion.text=args.question
        binding.btnAnswer.setOnClickListener {
            if (counter==0 || counter==2 || counter==4 || counter==5
                ||counter==7 || counter==9){
                binding.txtAnswer.text="true"
                cheatViewModel.updateAnswer(binding.txtAnswer.text.toString())
            }else{
                binding.txtAnswer.text="false"
                cheatViewModel.updateAnswer(binding.txtAnswer.text.toString())
            }

        }

    }


}