package com.example.myapplication8

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @ColumnInfo(name="name") val name:String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="userId") val userId:Int=0
    //primarykey는 이 객체의 고유한 키이다. 여기에 들어가는 값은 오직 하나만 존재. 예를 들면 고객대기번호표가 1이 두개가 있을 수 없는것처럼!
    //autoGenerate=true는 자동으로 이 타입에 따라서 숫자가 증가할 수 있게해준다. 우리가 값을 정해주지 않아도 자동으로 정해줌.
    //결론적으로 이 객체는 이름, 나이, 유저의 고유한 아이디로 구성되어 있다.
)