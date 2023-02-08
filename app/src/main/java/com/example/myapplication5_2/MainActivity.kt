package com.example.myapplication5_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication5_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>
    lateinit var mstring: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //dataList 생성과 adapter, layoutmanager 연결.
        val dataList: ArrayList<Data> = arrayListOf()
        val dataRVAdapter = DataRVAdapter(dataList)

        dataList.apply{
            add(Data("memo"))
            add(Data("memo2"))
        }

        binding.rvData.adapter = dataRVAdapter
        binding.rvData.layoutManager= LinearLayoutManager(this)

        //adapter에 item 삭제하고, adapter에 데이터 갱신.
        dataRVAdapter.setItemClickListener(object: DataRVAdapter.OnItemClickListener
        {
            override fun onClick(v: View, position : Int){
                dataList.removeAt(position)
                dataRVAdapter.notifyDataSetChanged()
            }
        })

        //registerForActivityResult 함수를 사용해서 callback 등록.
        getResultText = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {result ->
            if(result.resultCode== RESULT_OK){
                mstring= result.data?.getStringExtra("memo") ?:""
                dataList.apply{
                    add(Data(mstring))
                    dataRVAdapter.notifyDataSetChanged() //adapter에 정보가 추가되었으니, 갱신해야한다.
                }
            }
        }

        //위에서 정의한 것을 launch 함수로 시작.
        binding.btnAdd.setOnClickListener{
            val intent = Intent(this, MemoActivity::class.java)
            getResultText.launch(intent)
        }
    }
}