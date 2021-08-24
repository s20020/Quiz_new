package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quiz.databinding.ActivitySubBinding

class Sub : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var index = intent.getIntExtra("INDEX",1)
        var score = intent.getIntExtra("SCORE",0)

        //CSVを２次元配列に格納
        val assetManager = applicationContext.assets.open( "new_quiz.csv").bufferedReader()
        var a = assetManager.use() {
            it.readText()
        }
        var b = a.split(",")
        println(b[0])
        val taiga = "taiga"
        println(taiga)
        val a1 = b.take(6)
        b = b.drop(6)
        println(b)
        val a2 = b.take(6)
        b = b.drop(6)
        val a3 = b.take(6)
        b = b.drop(6)
        val a4 = b.take(6)
        b = b.drop(6)
        val a5 = b.take(6)
        b = b.drop(6)
        val a6 = b.take(6)
        b = b.drop(6)
        val a7 = b.take(6)
        b = b.drop(6)
        val a8 = b.take(6)
        b = b.drop(6)
        val a9 = b.take(6)
        b = b.drop(6)
        val a10 = b.take(6)
        b = b.drop(6)
        val a11 = b.take(6)
        b = b.drop(6)

        val array = Array(6) { IntArray(10) }
        val parent_list = arrayListOf(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)
        val parent_arr = parent_list.toTypedArray()
        println(parent_list)
        println(parent_arr)
        println(parent_arr[1])
        println(parent_list[3][3])


        var random = (1..10).random()
        println(random)
        var q1 = parent_list[1]
        println(q1)

        binding.subTitle.text = index.toString()
        binding.score.text = score.toString()
        binding.select1.text = q1[3]
        binding.select2.text = q1[4]


        index++





        binding.testButton.setOnClickListener { onChange(it, index, score) }





    }

    fun onChange (view: View?, index:Int, score: Int) {
        val intent = Intent(this, Sub::class.java).apply {
            intent.putExtra("INDEX", index)
            intent.putExtra("SCORE", score)
        }


        startActivity(intent)
    }

}