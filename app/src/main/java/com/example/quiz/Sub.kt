package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.get
import com.example.quiz.databinding.ActivitySubBinding

class Sub : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //インテントを受け取る
        var index = intent.getIntExtra("INDEX",1)
        var score = intent.getIntExtra("SCORE", 0)


        //CSVを２次元配列に格納

        //assetにあるnew_quiz.csvを読み込む
        val assetManager = applicationContext.assets.open( "new_quiz.csv").bufferedReader()
        var a = assetManager.use() {
            //すべてを変数aに代入
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

        //val array = Array(6) { IntArray(10) }
        //一つ一つの配列を合わせて２次元リストにする処理
        val parent_list = arrayListOf(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11)
        //val parent_arr = parent_list.toTypedArray()

        //indexでその都度、リストに中のリストを変数に代入
        var q = parent_list[index]

        //答えの保持
        val answer = q[2]

        //４択をランダムにする処理リストを作成
        val shahuruList = listOf(2,3,4,5)
        val num = shahuruList.shuffled()

        //text,radioButtonにそれぞれ値を入れる
        binding.subTitle.text = "第　${index.toString()}　問"
        binding.score.text = score.toString()
        binding.sentence.text = q[0]
        binding.select1.text = q[num[0]]
        binding.select2.text = q[num[1]]
        binding.select3.text = q[num[2]]
        binding.select4.text = q[num[3]]


        //10問まで数える
        index++

        println(index)


        //決定ボタンを押した時の処理
        binding.okButton.setOnClickListener {
            val id = binding.radioGroup.checkedRadioButtonId
            val comText = findViewById<RadioButton>(id).text

            if(comText == answer) {
                binding.test.text = "正解"
                score += 1
            }

            else
                binding.test.text = "不正解"


            if (index > 10) {
                resultChage(it, score)
            }





        }

        //次へボタンを押したときの処理
        binding.nextButton.setOnClickListener {
            onChange(it, index, score)
        }

    }

    //自分のクラスのインテントをわたす処理 index,scoreも渡す
    fun onChange (view: View?, index:Int, score: Int) {
        val intent = Intent(this, Sub::class.java)
            intent.putExtra("INDEX", index)
            intent.putExtra("SCORE", score)
        startActivity(intent)
    }

    //最終結果画面へ遷移　
    fun resultChage (view: View?, score: Int) {
        val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RESULT_SCORE",score.toString())
        startActivity(intent)
    }

}