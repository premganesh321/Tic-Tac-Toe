package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.databinding.ActivityHomePageBinding

class Home_page : AppCompatActivity() {
    private lateinit var bind : ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityHomePageBinding.inflate(layoutInflater)
        val vi = bind.root
        setContentView(vi)

        bind.btnplaywithfrnds.setOnClickListener(){
            val intent  = Intent(this , PlayWithFriends::class.java)
            startActivity(intent)
        }
        bind.btnplaywithComp.setOnClickListener(){
            val i  = Intent(this , PlayWithComputer::class.java)
            startActivity(i)
        }
    }
}