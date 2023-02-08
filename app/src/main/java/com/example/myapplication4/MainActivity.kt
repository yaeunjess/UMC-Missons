package com.example.myapplication4

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.myapplication4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding //activity_main.xml과 연결
    private lateinit var memo: String
    //private/public/protected 나중에초기화 변수선언할때 변수이름 : 변수타입 = 변수선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //.root:activity_main.xml에 있는 내용 다 가져오기기
       //여기까지 기본코드

        //기능 구현
        binding.btnMain.setOnClickListener{
            //클릭했을 때 일어나는 일
            val intent = Intent(this, SecondActivity::class.java) //택배상자 만들기
            intent.putExtra("memo",binding.edtMain.text.toString()) //putExtra(보내는사람, 보내는물건)
            startActivity(intent) //택배보내기
        }
    }

    override fun onStop(){
        super.onStop()
        memo = binding.edtMain.text.toString() //기능 1번
        binding.edtMain.setText(null) //기능 2번
    }

    override fun onRestart(){
        super.onRestart()
        var builder = AlertDialog.Builder(this) //alertdialog 생성

        builder.setTitle("알림") //타이틀
            .setMessage("이어서 작성하시겠습니까?") //내용
            .setPositiveButton("예"){ dialog, i->binding.edtMain.setText(memo) //없앴던 내용 불러오기
                binding.edtMain.setSelection((binding.edtMain.length()))} //setSelection: 커서 옮기기
            .setNegativeButton("아니오") {dialog, i->binding.edtMain.setText(null)
                memo=""} //"" null이랑 같은 기능
        builder.show()
    }
}