package com.example.myapplication8_1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[User::class], version=1) //User 데이터의 구조를 바꾸면, 꼭 version을 바꿔서 다른 version인걸 알려줘야함.
abstract class AppDatabase: RoomDatabase() { //database 객체를 가져옴.
    abstract fun UserDao(): UserDao //UserDao 연결해주는?

    companion object{
        private var appDatabase: AppDatabase? = null

        //밑에 코드는 깊게 이해하려하면 어려움.. 코드는 따라치기를 추천함.
        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if(appDatabase == null){
                synchronized(AppDatabase::class.java){
                    appDatabase = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app-database"
                    ).allowMainThreadQueries().build()
                }
            }
            return appDatabase
        }
    }
}