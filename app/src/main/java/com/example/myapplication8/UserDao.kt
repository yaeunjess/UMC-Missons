package com.example.myapplication8

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao { //Data의 값을 삽입, 삭제, 조회, 업데이트하는 녀석.
    //삽입
    @Insert
    fun insert(user: User)  //함수 위에 @~~써주는게 국룰인가봄 ㅇㅇ..

    //삭제
    @Delete
    fun delete(user: User)

    @Query("DELETE FROM User")
    fun deleteAll()

    //조회
    @Query("SELECT * FROM User")
    fun selectAll(): List<User>  //:뒤에는 return 값이다.

    @Query("SELECT * FROM User WHERE userId = :userId")
    fun selectByUserId(userId: Int): User

    @Query("SELECT * FROM User WHERE name = :name")
    fun selectByName(name: String): List<User>

    //업데이트
    @Query("UPDATE User SET name=:name WHERE userId= :userId")
    fun updateNameByUser(userId: Int, name: String)
}