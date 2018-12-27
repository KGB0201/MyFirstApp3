package com.dotinstall.myfirstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var numberStr: String = ""   //数式の数を保持する変数
    var numberList = ArrayList<Double>()
    val oList = ArrayList<Char>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// Number
        number0.setOnClickListener {
            formula.text = "${formula.text}0"
            numberStr += "0"
                                   }
        number1.setOnClickListener {
            formula.text = "${formula.text}1"
            numberStr += "1"
                                   }
        number2.setOnClickListener {
            formula.text = "${formula.text}2"
            numberStr += "2"
                                   }
        number3.setOnClickListener {
            formula.text = "${formula.text}3"
            numberStr += "3"
                                   }
        number4.setOnClickListener {
            formula.text = "${formula.text}4"
            numberStr += "4"
                                   }
        number5.setOnClickListener {
            formula.text = "${formula.text}5"
            numberStr += "5"
                                   }
        number6.setOnClickListener {
            formula.text = "${formula.text}6"
            numberStr += "6"
                                   }
        number7.setOnClickListener {
            formula.text = "${formula.text}7"
            numberStr += "7"
                                   }
        number8.setOnClickListener {
            formula.text = "${formula.text}8"
            numberStr += "8"
                                   }
        number9.setOnClickListener {
            formula.text = "${formula.text}9"
            numberStr += "9"
                                   }

// Symbol
        dot.setOnClickListener {
            formula.text = "${formula.text}."
            numberStr += "."
                               }
        equal.setOnClickListener {
            formula.text = "${formula.text}="
            addList(numberStr)
            var result = calculate().toString()
            formula.text = result
            numberStr = result
            numberList.clear()
            oList.clear()
                                 }
        plus.setOnClickListener {
            formula.text = "${formula.text}+"
            addList(numberStr, '+')
            numberStr = ""
                                }
        minus.setOnClickListener {
            formula.text = "${formula.text}-"
            addList(numberStr, '-')
            numberStr = ""
                                 }
        multiplication.setOnClickListener {
            formula.text = "${formula.text}*"
            addList(numberStr, '*')
            numberStr = ""
                                          }
        divide.setOnClickListener {
            formula.text = "${formula.text}/"
            addList(numberStr, '/')
            numberStr = ""
                                  }
        delete.setOnClickListener {
            var formulaStr = formula.text.toString()
            if (!formulaStr.isEmpty()) {
                formula.text = formulaStr.subSequence(0, formulaStr.lastIndex)
                                       }
            if (!numberStr.isEmpty()) {
                numberStr = numberStr.substring(0, numberStr.lastIndex)
                                      }
                                  }
        percent.setOnClickListener {
            formula.text = "${formula.text}%"
            addList(numberStr, '%')
            numberStr = ""
                                   }
        sign.setOnClickListener {
            formula.text = "${formula.text}+/-"
                                }

        clear.setOnClickListener {
            formula.text = ""
            numberStr = ""
            numberList.clear()
            oList.clear()
                                 }
    }// OnCreate

// Function
        fun addList(str : String, ope : Char) {
            try{
                var num = str.toDouble()
                numberList.add(num)
                oList.add(ope)
               }catch(e:Exception){
                formula.text = "Numeric error"
                                  }
                                              }

        fun addList(str : String){
            try{
                var num = str.toDouble()
                numberList.add(num)
               }catch(e:Exception){
                formula.text = "Numeric error"
                                  }
                                 }

        fun calculate() : Double {
           var i = 0
           while( i < oList.size) {
               if(oList.get(i) == '*' || oList.get(i) == '/')
               {
                   var result  = if (oList.get(i) == '*') numberList.get(i) * numberList.get(i+1) else numberList.get(i)/numberList.get(i+1)
                   numberList.set(i, result)
                   numberList.removeAt(i+1)
                   oList.removeAt(i)
                   i--
               }else if(oList.get(i) == '-'){
                   oList.set(i,'+')
                   numberList.set(i+1, numberList.get(i+1) * -1)
                                            }
               i++
                                  }
            var result = 0.0
            for (i in numberList){
                result += i
                                 }
            return result
        }
}//  MainActivity
