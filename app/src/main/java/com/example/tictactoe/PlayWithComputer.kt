package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.tictactoe.databinding.ActivityPlayWithComputerBinding
import kotlinx.coroutines.delay
import java.util.Random
import java.util.Timer
import java.util.TimerTask
import kotlin.concurrent.schedule
import kotlin.system.exitProcess

class PlayWithComputer : AppCompatActivity() {
    private var ids = mutableListOf<Button>()
    private lateinit var bindi : ActivityPlayWithComputerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindi = ActivityPlayWithComputerBinding.inflate(layoutInflater)
        val views  = bindi.root
        setContentView(views)
        ids.addAll(
            listOf(
                bindi.btn1, bindi.btn2, bindi.btn3,
                bindi.btn4, bindi.btn5, bindi.btn6,
                bindi.btn7, bindi.btn8, bindi.btn9
            )
        )

    }
    var x = 0
    var n = 9
    var Hwin = 0
    var Cwin = 0
    var drawHC = 0


    fun onclickByHuman(view: View) {
        val button = view as Button
        if (button.text == "") {
            button.text = "X"
            bindi.txtwinner.text = "It's My Turn"
            button.setTextColor(ContextCompat.getColor(this, R.color.X))
            ids.remove(button)
            n -= 1
            if(n!=0){
                movebycomp()
            }
        }
        Winner()
    }

    private fun movebycomp() {
        val r = Random()
        val randnum = r.nextInt(ids.size)
        val randbt = ids[randnum]

        if (randbt.text == "") {
            randbt.text = "O"
            bindi.txtwinner.text = "It's Your Turn"
            randbt.setTextColor(ContextCompat.getColor(this, R.color.O))
            ids.remove(randbt)
            n -= 1
        }
    }

    private fun Winner(){
        CheckWinner(bindi.btn1 , bindi.btn2 , bindi.btn3 , bindi.txtwinner , bindi.txtUpdateData)
        CheckWinner(bindi.btn4 , bindi.btn5 , bindi.btn6 , bindi.txtwinner , bindi.txtUpdateData)
        CheckWinner(bindi.btn7 , bindi.btn8 , bindi.btn9 , bindi.txtwinner , bindi.txtUpdateData)
        CheckWinner(bindi.btn1 , bindi.btn4 , bindi.btn7 , bindi.txtwinner , bindi.txtUpdateData)
        CheckWinner(bindi.btn2 , bindi.btn5 , bindi.btn8 , bindi.txtwinner , bindi.txtUpdateData)
        CheckWinner(bindi.btn3 , bindi.btn6 , bindi.btn9 , bindi.txtwinner , bindi.txtUpdateData)
        CheckWinner(bindi.btn1 , bindi.btn5 , bindi.btn9 , bindi.txtwinner , bindi.txtUpdateData)
        CheckWinner(bindi.btn3 , bindi.btn5 , bindi.btn7 , bindi.txtwinner , bindi.txtUpdateData)
    }


    private fun CheckWinner(V1 : Button, V2: Button, V3:Button, txt: TextView, txt1 : TextView){
        val x = V1.text.toString()
        val y = V2.text.toString()
        val z = V3.text.toString()

        if(x==y && y==z && !x.isEmpty() ){
            var k ="The Winner is ${x}"
            txt.text = k
            if(x=="X"){
                Hwin+=1
                txt1.text = "Human : $Hwin       D : $drawHC       Computer: $Cwin"
            }
            else{
                Cwin+=1
                txt1.text = "Human : $Hwin       D : $drawHC       Computer: $Cwin"
            }
            restartHCGame()
        }
        else if(n==0){
            restartHCGame()
            txt.text = "Let's restart the Game "
            drawHC+=1
            txt1.text = "Human : $Hwin       D : $drawHC       Computer: $Cwin"
        }

    }

    private fun restartHCGame() {
        bindi.btn1.text = ""
        bindi.btn2.text = ""
        bindi.btn3.text = ""
        bindi.btn4.text = ""
        bindi.btn5.text = ""
        bindi.btn6.text = ""
        bindi.btn7.text = ""
        bindi.btn8.text = ""
        bindi.btn9.text = ""
        bindi.btn1.setBackgroundResource(R.color.boxcolour)
        bindi.btn2.setBackgroundResource(R.color.boxcolour)
        bindi.btn3.setBackgroundResource(R.color.boxcolour)
        bindi.btn4.setBackgroundResource(R.color.boxcolour)
        bindi.btn5.setBackgroundResource(R.color.boxcolour)
        bindi.btn6.setBackgroundResource(R.color.boxcolour)
        bindi.btn7.setBackgroundResource(R.color.boxcolour)
        bindi.btn8.setBackgroundResource(R.color.boxcolour)
        bindi.btn9.setBackgroundResource(R.color.boxcolour)
        n = 9
        ids = mutableListOf(
            bindi.btn1, bindi.btn2, bindi.btn3,
            bindi.btn4, bindi.btn5, bindi.btn6,
            bindi.btn7, bindi.btn8, bindi.btn9)

    }


}