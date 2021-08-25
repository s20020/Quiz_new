package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quiz.databinding.ActivityResultBinding
import com.example.quiz.databinding.ActivitySubBinding
import java.util.zip.Inflater

class ResultActivity : AppCompatActivity() {
    private lateinit var binding : ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //最終結果を受け取る処理
        val resultScore = intent.getStringExtra("RESULT_SCORE")

        //正解数を表示
        binding.resultScore.text = resultScore
    }
}