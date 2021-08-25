package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.quiz.databinding.ActivitySubBinding

class Sub : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //自身のインテントを受け取る処理
        var index = intent.getIntExtra("INDEX",1)
        var score = intent.getIntExtra("SCORE", 0)

        //タイマーをつくる


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

        //val array = Array(6) { IntArray(10) }
        //２次元リストをつくる
        val parent_list = arrayListOf(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)
        //val parent_arr = parent_list.toTypedArray()



        //４択をランダムに表示するためのリストをつくる
        val list = listOf(2,3,4,5)
        val num = list.shuffled()

        //今の問題に対応するリストを２次元リストから変数に代入
        var q = parent_list[index]

        //答えを保持
        val answer = q[2]



        //それぞれのビューに値を代入
        binding.subTitle.text = "第　${index.toString()}　問"
        binding.score.text = score.toString()
        binding.sentence.text = q[0]
        binding.select1.text = q[num[0]]
        binding.select2.text = q[num[1]]
        binding.select3.text = q[num[2]]
        binding.select4.text = q[num[3]]


        //10問目まで数える
        index++

        //正解か不正解か判定する
        binding.okButton.setOnClickListener {
            //選ばれているボタンのテキストを取得
            val id = binding.radioGroup.checkedRadioButtonId
            val radioButton = findViewById<RadioButton>(id)
            val selectText = radioButton.text

            //正解の場合、
            if(selectText == answer) {
                binding.test.text = "正解"
                score++
            }
            //不正解の場合
            else
                binding.test.text = "不正解"
        }

        //次へボタンが押されたとにindexの値によって処理を変更する処理
        binding.nextButton.setOnClickListener {
            if (index > 10)
                resultChange(it, score)
            else
                onChange(it, index, score)
        }




    }
    //決定ボタンが押された時の処理
    fun onChange (view: View?, index:Int, score: Int) {
        val intent = Intent(this, Sub::class.java)
            intent.putExtra("INDEX", index)
            intent.putExtra("SCORE", score)
        startActivity(intent)
    }

    //次へボタンを押したときの処理
    fun resultChange (view: View?, score: Int) {
        val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT_SCORE", score.toString())
        startActivity(intent)
    }

}