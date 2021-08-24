package com.example.quiz

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quiz.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {
    private var _binding : FragmentQuizBinding? = null
    private val binding get() = _binding!!

    inner class countDownTimer(millisUntilFinished: Long,
                               countDownInterval: Long
    ) : CountDownTimer(millisUntilFinished, countDownInterval) {
        override fun onTick(millisUntilFinished: Long) {
            //var time = millisUntilFinished/ 1000


        }

        override fun onFinish() {
            binding
        }
    }



    override fun onCreateView( inflater: LayoutInflater, //フラグメント内のビュー作成のためのオブジェクト
                               container: ViewGroup?,    //ブラグメントの親となるビューグループ
                               savedInstanceState: Bundle? // フラグメントの状態を維持するBundleオブジェクト
    ):View? {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root

    }
    private var random = (1..10).random()

    //フラグメント削除 (必須)
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setTitle(title: String) {

    }

}