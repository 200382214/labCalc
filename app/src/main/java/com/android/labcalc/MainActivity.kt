package com.android.labcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        tvOne.setOnClickListener { append("1", true) }
        tvTwo.setOnClickListener { append("2", true) }
        tvThree.setOnClickListener { append("3", true) }
        tvFour.setOnClickListener { append("4", true) }
        tvFive.setOnClickListener { append("5", true) }
        tvSix.setOnClickListener { append("6", true) }
        tvSeven.setOnClickListener { append("7", true) }
        tvEight.setOnClickListener { append("8", true) }
        tvNine.setOnClickListener { append("9", true) }
        tvZero.setOnClickListener { append("0", true) }

        //Operator
        tvPlus.setOnClickListener { append("+", false) }

        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }
        tvEquals.setOnClickListener {


            try {

                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()

            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }
        }

    }

    fun append(string: String, canClear: Boolean) {

        if(tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }

        if (canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }
}
