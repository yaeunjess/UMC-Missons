package com.example.myapplication6_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication6_1.databinding.ActivityMainBinding
import com.example.myapplication6_1.databinding.FragmentSearchBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val viewBinding:ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        //Fragment를 Container에 할당
        supportFragmentManager
            .beginTransaction() //Fragment 처리 시작
            .replace(viewBinding.containerFragment.id, HomeFragment()) //Container와 새로 넣을 Fragment 객체
            .commitAllowingStateLoss() //commit : 처리 내용 저장

        viewBinding.navBottom.run{
            setOnItemSelectedListener {
                when(it.itemId){
                    R.id.menu_home -> {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id,HomeFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_search ->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id,SearchFragment())
                            .commitAllowingStateLoss()
                    }
                    R.id.menu_setting ->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(viewBinding.containerFragment.id,SettingFragment())
                            .commitAllowingStateLoss()
                    }
                }
                true
            }
            selectedItemId = R.id.menu_home
        }
    }
}