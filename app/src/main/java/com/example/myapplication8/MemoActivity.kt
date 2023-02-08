package com.example.myapplication8

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication8.databinding.ActivityMemoBinding

class MemoActivity :AppCompatActivity() {

    lateinit var binding: ActivityMemoBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val roomDb = AppDatabase.getInstance(this)

        binding.btnSave.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java).apply{
                putExtra("memo", binding.edtMemo.text.toString())
            }
            val memo = User(binding.edtMemo.text.toString())
            roomDb?.UserDao()?.insert(memo) //데이터 삽입하기
            val userList = roomDb?.UserDao()?.selectAll()  //데이터 모두 조회하기
            Log.d("DB","User List:${userList}")
            setResult(RESULT_OK, intent)
            if(!isFinishing) finish()
        }
    }
}