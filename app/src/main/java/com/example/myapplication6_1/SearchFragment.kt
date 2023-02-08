package com.example.myapplication6_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication6_1.databinding.FragmentSearchBinding
import com.google.android.material.tabs.TabLayoutMediator

class SearchFragment: Fragment() {

    lateinit var viewBinding : FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewBinding = FragmentSearchBinding.inflate(layoutInflater)

        //viewpager adapter 가져오기
        val mainVPAdapter = MainVPAdapter(this)

        //adapter랑 객체랑 연결하기
        viewBinding.vpFrag.adapter = mainVPAdapter

        //tablayout에서의 tab들을 담는 배열.
        val tabTitleArray=arrayOf(
            "Naver",
            "Google",
            "Daum",
        )

        //tablayout과 연결하기
        TabLayoutMediator(viewBinding.tabFrag, viewBinding.vpFrag){ tab, position->
            tab.text = tabTitleArray[position]
        }.attach()

        return viewBinding.root
    }
}