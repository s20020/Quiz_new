package com.example.quiz

import android.content.Intent
import android.content.res.AssetManager
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.example.quiz.databinding.ActivityMainBinding
import com.opencsv.CSVIterator
import com.opencsv.CSVReader
import kotlinx.serialization.descriptors.StructureKind
import java.io.InputStream
import java.io.StringReader
import java.nio.file.Paths

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//
//        var index = 1
//        var score = 0


        binding.StartButton.setOnClickListener { onChange(it) }

       //テスト用テキスト
       //binding.testText.text = parent_arr[1][3]
        }

   fun onChange (view: View?) {
       val intent = Intent(this, Sub::class.java)
        startActivity(intent)
    }



}









