package com.example.tictactoe

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat
import com.example.tictactoe.databinding.ActivityPlaywithfrndsBinding

class PlayWithFriends : ComponentActivity() {
    private lateinit var bi : ActivityPlaywithfrndsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = ActivityPlaywithfrndsBinding.inflate(layoutInflater)
        val view = bi.root
        setContentView(view)


    }
    var a = 1
    var b = 0
    var c = 0
    var xwin = 0
    var ywin = 0
    var drawg = 0
    fun onButtonClick(view: View) {
        val button = view as Button
        if(button.text == ""){
            if (a > b) {
                bi.txtwinner.text = "It's O Turn"
                button.setTextColor(ContextCompat.getColor(this ,R.color.O))
                button.text = "X"
                a--
                b++
            } else {
                bi.txtwinner.text = "It's X Turn"
                button.setTextColor(ContextCompat.getColor(this ,R.color.X))
                button.text = "O"
                a++
                b--
            }
            c++
        }
        Winner()
    }

    private fun Winner(){
        CheckWinner(bi.btn1 , bi.btn2 , bi.btn3 , bi.txtwinner , bi.txtUpdateData)
        CheckWinner(bi.btn4 , bi.btn5 , bi.btn6 , bi.txtwinner , bi.txtUpdateData)
        CheckWinner(bi.btn7 , bi.btn8 , bi.btn9 , bi.txtwinner , bi.txtUpdateData)
        CheckWinner(bi.btn1 , bi.btn4 , bi.btn7 , bi.txtwinner , bi.txtUpdateData)
        CheckWinner(bi.btn2 , bi.btn5 , bi.btn8 , bi.txtwinner , bi.txtUpdateData)
        CheckWinner(bi.btn3 , bi.btn6 , bi.btn9 , bi.txtwinner , bi.txtUpdateData)
        CheckWinner(bi.btn1 , bi.btn5 , bi.btn9 , bi.txtwinner , bi.txtUpdateData)
        CheckWinner(bi.btn3 , bi.btn5 , bi.btn7 , bi.txtwinner , bi.txtUpdateData)
    }


    private fun CheckWinner(V1 : Button , V2: Button , V3:Button , txt: TextView , txt1 : TextView){
        val x = V1.text.toString()
        val y = V2.text.toString()
        val z = V3.text.toString()
        Log.d("x1" , x)
        Log.d("y1" , y)
        Log.d("z1" , z)
        if(x==y && y==z && !x.isEmpty() ){
            var k ="The Winner is ${x}"
            txt.text = k
            if(x=="X"){
                xwin+=1
                txt1.text = "X : $xwin          D : $drawg         O: $ywin"
            }
            else{
                ywin+=1
                txt1.text = "X : $xwin          D : $drawg         O: $ywin"
            }

            restart()
        }
        else if(c==9){
            restart()
            txt.text = "Let's restart the Game "
            drawg+=1
            txt1.text = "X : $xwin          D : $drawg         O: $ywin"
        }

    }

    private fun restart(){
        bi.btn1.text = ""
        bi.btn2.text = ""
        bi.btn3.text = ""
        bi.btn4.text = ""
        bi.btn5.text = ""
        bi.btn6.text = ""
        bi.btn7.text = ""
        bi.btn8.text = ""
        bi.btn9.text = ""
        bi.btn1.setBackgroundResource(R.color.boxcolour)
        bi.btn2.setBackgroundResource(R.color.boxcolour)
        bi.btn3.setBackgroundResource(R.color.boxcolour)
        bi.btn4.setBackgroundResource(R.color.boxcolour)
        bi.btn5.setBackgroundResource(R.color.boxcolour)
        bi.btn6.setBackgroundResource(R.color.boxcolour)
        bi.btn7.setBackgroundResource(R.color.boxcolour)
        bi.btn8.setBackgroundResource(R.color.boxcolour)
        bi.btn9.setBackgroundResource(R.color.boxcolour)
        a=1
        b=0
        c=0
    }



}
