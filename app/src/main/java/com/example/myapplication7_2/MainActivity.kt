package com.example.myapplication7_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication7_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //dataList 생성과 adapter, layoutmanager 연결.
        val dataList: ArrayList<Data> = arrayListOf()
        val dataRVAdapter = DataRVAdapter(dataList)

        dataList.apply{
            add(Data(R.drawable.bam,"아이유", "밤편지"))
            add(Data(R.drawable.sajipeong,"사건의 지평선", "윤하"))
        }

        binding.rvData.adapter = dataRVAdapter
        binding.rvData.layoutManager= LinearLayoutManager(this)
    }
}