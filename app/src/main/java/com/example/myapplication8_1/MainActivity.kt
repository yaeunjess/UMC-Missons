package com.example.myapplication8_1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication8_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val roomDb = AppDatabase.getInstance(this) //AppDatabase에 있는 getInstance 함수 실행

        if(roomDb != null){
            val user = User("에릭",23)  //우리가 객체 하나 생성해줌!
            roomDb.UserDao().insert(user)  //데이터 삽입하기
            //roomDb.UserDao().updateNameByUser(1,"루나")  //데이터 업데이트하기

            val userList = roomDb.UserDao().selectAll()  //데이터 모두 조회하기
            Log.d("DB","User List:${userList}")
        }
    }
}