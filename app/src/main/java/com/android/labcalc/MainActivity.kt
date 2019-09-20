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
        tvOne.setOnClickListener { appendOnExpresstion("1", true) }
        tvTwo.setOnClickListener { appendOnExpresstion("2", true) }
        tvThree.setOnClickListener { appendOnExpresstion("3", true) }
        tvFour.setOnClickListener { appendOnExpresstion("4", true) }
        tvFive.setOnClickListener { appendOnExpresstion("5", true) }
        tvSix.setOnClickListener { appendOnExpresstion("6", true) }
        tvSeven.setOnClickListener { appendOnExpresstion("7", true) }
        tvEight.setOnClickListener { appendOnExpresstion("8", true) }
        tvNine.setOnClickListener { appendOnExpresstion("9", true) }
        tvZero.setOnClickListener { appendOnExpresstion("0", true) }

        //Operator
        tvPlus.setOnClickListener { appendOnExpresstion("+", false) }

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

    fun appendOnExpresstion(string: String, canClear: Boolean) {

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
