package com.example.myapplication4

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(){

    lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root) //여기까지 기본 세팅

        binding.txtSecond.text = intent.extras!!["memo"] as String  //as String: String으로 받아라
        //!!: null 값이면 받지마, ?: null 값 가능
    }
}