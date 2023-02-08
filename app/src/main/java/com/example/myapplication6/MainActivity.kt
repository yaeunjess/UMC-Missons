package com.example.myapplication6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication6.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val viewBinding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        //viewpager adapter 가져오기
        val mainVPAdapter = MainVPAdapter(this)

        //adapter랑 객체랑 연결하기
        viewBinding.vpMain.adapter = mainVPAdapter

        //tablayout에서의 tab들을 담는 배열.
        val tabTitleArray=arrayOf(
            "One",
            "Two",
        )

        //tablayout과 연결하기
        TabLayoutMediator(viewBinding.tabMain, viewBinding.vpMain){ tab, position->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}