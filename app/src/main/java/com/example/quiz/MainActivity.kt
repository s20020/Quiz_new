package com.example.quiz

import android.content.Intent
import android.content.res.AssetManager
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quiz.databinding.ActivityMainBinding
import kotlinx.serialization.descriptors.StructureKind
import java.io.InputStream
import java.nio.file.Paths

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.StartButton.setOnClickListener { onChange(it) }

        val assetManager = applicationContext.assets.open( "quiz.csv").bufferedReader()

        var a = assetManager.use() {
            it.readText()
        }
        println(assetManager)

        var b = a.split(",")
        println(b)
        println(b.size)

        val array = Array(10, {arrayOfNulls<Int>(10)})

        var c =array.toList()


        binding.testText.text = b[8]
        }

    fun onChange (view: View?) {
        val intent = Intent(this, ResultActivity::class.java)
        startActivity(intent)
    }



}







