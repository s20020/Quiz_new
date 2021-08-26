package com.example.quiz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.quiz.databinding.ActivitySubBinding
import kotlin.concurrent.timer
import kotlin.system.measureTimeMillis
import kotlin.text.Typography.times

class Sub : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //自身のインテントを受け取る処理
        var index = intent.getIntExtra("INDEX",1)
        var score = intent.getIntExtra("SCORE", 0)



        //CSVを２次元配列に格納
        val assetManager = applicationContext.assets.open( "new_quiz.csv").bufferedReader()
        var a = assetManager.use() {
            it.readText()
        }
        var b = a.split(",")

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

        //２次元リストをつくる
        val parent_list = arrayListOf(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)

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



        //タイマーのインスタンスを生成

        //binding.timer.text = "10"

        val timer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val second = millisUntilFinished / 1000L % 60L
                binding.timer.text = second.toString()
            }

            //終了したら、次へボタンを明示的にクリック
            override fun onFinish() {
                //binding.timer.text = "終了"
                binding.okButton.performClick()
                //binding.nextButton.performClick()
            }
        }.start()

        index++

        val times = measureTimeMillis {
            timer.start()
        }
        println(times)


        //okButtonか10秒が立った時に正解か不正解を表示

        val handler = Handler(Looper.getMainLooper())

        binding.okButton.setOnClickListener {

            //選ばれているボタンのテキストを取得
            val id = binding.radioGroup.checkedRadioButtonId
            val radioButton = findViewById<RadioButton>(id)
            val selectText = radioButton.text

            //正解の場合、
            if(selectText == answer) {
                binding.test.text = "⭕"
                score++
            }

            //不正解の場合
            else
                binding.test.text = "❌"

            //1秒後に画面遷移
            handler.postDelayed( {
                binding.nextButton.performClick()
            }, 1000)

        }

        //次の画面への遷移
        binding.nextButton.setOnClickListener {
            //１０を超えた場合は最終結果へ
            if (index > 10) {
                timer.cancel()
                resultChange(it, score)
            }
            //１０以下の場合は次の問題へ
            else {
                timer.cancel()
                onChange(it, index, score)
            }

        }


    }
    //indexが１０以下の処理
    fun onChange (view: View?, index:Int, score: Int) {
        val intent = Intent(this, Sub::class.java)
            intent.putExtra("INDEX", index)
            intent.putExtra("SCORE", score)
        startActivity(intent)
    }

    //indexが１０を超えた時最終画面へ遷移
    fun resultChange (view: View?, time: Int) {
        
        val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT_SCORE", time.toString())
        startActivity(intent)
    }


}